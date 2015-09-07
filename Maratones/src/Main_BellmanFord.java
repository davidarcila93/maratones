import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_BellmanFord {
	static int[] d;
	static ArrayList<ArrayList<Node>> adj;
	static int n;
	static int INF=1<<30;
	
	public static class Node implements Comparable<Node>{
		int index;
		int cost;
		Node(int index, int cost){
			this.index=index;
			this.cost=cost;
		}
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	public static void init(){
		d=new int[n];
		Arrays.fill(d, INF);
		adj=new ArrayList<ArrayList<Node>>();
		ArrayList<Node> aux;
		for (int i = 0; i < n; i++) {
			aux=new ArrayList<Node>();
			adj.add(aux);
		}
	}
	
	public static void BellmanFord(int source){
		d[source]=0;
		Node aux;
		int to, c;
		for (int iter = 0; iter < n-1; iter++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < adj.get(i).size(); j++) {
					aux=adj.get(i).get(j);
					to=aux.index;
					c=aux.cost;
					d[to]=Math.min(d[to], d[i]+c);
				}
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cases=Integer.parseInt(br.readLine());
		int m, a, b, w;
		for (int i = 0; i < cases; i++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			init();
			for (int j = 0; j < m; j++) {
				st=new StringTokenizer(br.readLine());
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				w=Integer.parseInt(st.nextToken());
				adj.get(a).add(new Node(b, w));
			}
			BellmanFord(0);
			boolean negcycle=false;
			Node aux;
			int to, c;
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < adj.get(j).size(); j2++) {
					aux=adj.get(j).get(j2);
					to=aux.index;
					c=aux.cost;
					if(d[to]>d[j]+c){
						negcycle=true;
						break;
					}
				}
				if(negcycle)
					break;
			}
			if(negcycle)
				System.out.println("possible");
			else
				System.out.println("not possible");
		}
		
	}
}
