import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_Dijkstra {
	static int d[];
	static int n, INF=1<<30;
	static ArrayList<ArrayList<Node>> adj;
	static PriorityQueue<Node> pq;
	
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
		pq=new PriorityQueue<Node>();
	}
	
	public static void Dijkstra(int source){
		d[source]=0;
		pq.add(new Node(source, 0));
		int from, distance, to, c;
		Node cur;
		while(!pq.isEmpty()){
			cur=pq.poll();
			from=cur.index;
			distance=cur.cost;
			if(d[from]!=distance)continue;
			for (int i = 0; i < adj.get(from).size(); i++) {
				to=adj.get(from).get(i).index;
				c=adj.get(from).get(i).cost;
				if(d[to]>d[from]+c){
					d[to]=d[from]+c;
					pq.add(new Node(to, d[to]));
				}
			}	
		}	
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a, b, w;
		int m, cases, source, target;
		cases=Integer.parseInt(br.readLine());
		for (int i = 0; i < cases; i++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			source=Integer.parseInt(st.nextToken());
			target=Integer.parseInt(st.nextToken());
			init();
			for (int j = 0; j < m; j++) {
				st=new StringTokenizer(br.readLine());
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				w=Integer.parseInt(st.nextToken());
				adj.get(a).add(new Node(b, w));
				adj.get(b).add(new Node(a, w));
			}
			Dijkstra(source);
			if(d[target]==INF)
				System.out.println("Case #"+(i+1)+": unreachable");
			else
				System.out.println("Case #"+(i+1)+": "+d[target]);
		}
	}
}
