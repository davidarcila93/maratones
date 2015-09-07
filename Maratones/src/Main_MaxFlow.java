import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main_MaxFlow {
	
	static int INF=1<<30;
	static int n;
	static int[] f;
	static int[] c;
	static ArrayList<Integer>[] g;
	static ArrayList<Integer>[] flowRef;
	static int nE;
	
	public static void CreateInstance(){
		g=new ArrayList[n];
		flowRef=new ArrayList[n];
		for (int i = 0; i < n; i++) {
			g[i]=new ArrayList<Integer>();
			flowRef[i]=new ArrayList<Integer>();
		}
		c=new int[4*n*n];
		f=new int[4*n*n];
		nE=0;
	}
	
	public static void AddEdge(int src, int dst, int cap){
		if(g[src].contains(dst)){
			int aux=flowRef[src].get(g[src].indexOf(dst));
			c[aux]+=cap;
			c[aux^1]+=cap;
		}
		else{
			g[src].add(dst);
			flowRef[src].add(nE);
			c[nE]=cap;
			f[nE]=0;
			nE++;
			g[dst].add(src);
			flowRef[dst].add(nE);
			c[nE]=cap;
			f[nE]=0;
			nE++;
		}
		
	}
	
	public static void ClearFlow(){
		for (int i = 0; i < nE; i++) {
			f[i]=0;
		}
	}
	
	static int prevEdge[];
	static int prevVertex[];
	static int inFlow[];
	
	public static boolean BFS(int s, int t){
		for (int i = 0; i < n; i++) {
			inFlow[i]=-INF;
		}
		int Q[]=new int[n];
		int qS=0;
		int qH=0;
		Q[qS++]=s;
		inFlow[s]=INF;
		prevEdge[s]=-1;
		while(qH<qS){
			int act=Q[qH++];
			if(act==t)
				break;
			for (int i = 0; i < g[act].size(); i++) {
				int vertex=g[act].get(i);
				int edge=flowRef[act].get(i);
				if(f[edge]==c[edge])
					continue;
				if(inFlow[vertex]!=-INF)
					continue;
				Q[qS++]=vertex;
				prevEdge[vertex]=edge;
				prevVertex[vertex]=act;
				inFlow[vertex]=Math.min(inFlow[act], c[edge]-f[edge]);
			}
		}
		return inFlow[t]!=-INF;
	}
	
	public static int MaxFlowBFS(int s, int t){
		prevEdge=new int[n];
		prevVertex=new int[n];
		inFlow=new int[n];
		int result=0;
		while(BFS(s,t)){
			int act=t;
			while(act!=s){
				int e=prevEdge[act];
				f[e]+=inFlow[t];
				f[e^1]-=inFlow[t];
				act=prevVertex[act];
			}
			result+=inFlow[t];
		}
		return result;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int s, t, c;
		int a, b, w;
		int casos=0;
		while((n=Integer.parseInt(br.readLine()))!=0){
			casos++;
			st=new StringTokenizer(br.readLine());
			s=Integer.parseInt(st.nextToken())-1;
			t=Integer.parseInt(st.nextToken())-1;
			c=Integer.parseInt(st.nextToken());
			CreateInstance();
			for (int i = 1; i <= c; i++) {
				st=new StringTokenizer(br.readLine());
				a=Integer.parseInt(st.nextToken())-1;
				b=Integer.parseInt(st.nextToken())-1;
				w=Integer.parseInt(st.nextToken());
				AddEdge(a, b, w);
			}
			System.out.println("Network "+casos);
			System.out.println("The bandwidth is "+ MaxFlowBFS(s, t) +".");
			System.out.println();
		}	
	}
}
