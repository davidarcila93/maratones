import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_FullTank2 {
	static ArrayList<ArrayList<Pair>> adj;
	static PriorityQueue<Node> pq=new PriorityQueue<Node>();
	static int INF=1<<30;
	static int d[][];
	static int price[];
	static int n;
	
	public static class Pair{
		int first;
		int second;
		Pair(int first, int second){
			this.first=first;
			this.second=second;
		}
	}
	
	public static class Node implements Comparable<Node>{
		int index;
		int fuel;
		int cost;
		Node(int index, int fuel, int cost){
			this.index=index;
			this.fuel=fuel;
			this.cost=cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int m, q, s, t, tank,a ,b, c;
		st=new StringTokenizer(br.readLine().trim());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		price=new int[n];
		st=new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			price[i]=Integer.parseInt(st.nextToken());
		}
		adj=new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Pair>());
		}
		for (int i = 0; i < m; i++) {
			st=new StringTokenizer(br.readLine().trim());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			adj.get(a).add(new Pair(b, c));
			adj.get(b).add(new Pair(a, c));
		}
		q=Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < q; i++) {
			st=new StringTokenizer(br.readLine().trim());
			tank=Integer.parseInt(st.nextToken());
			s=Integer.parseInt(st.nextToken());
			t=Integer.parseInt(st.nextToken());
			d=new int[n][tank+1];
			for (int j = 0; j < n; j++) {
				Arrays.fill(d[j], INF);
			}
			d[s][0]=0;
			pq.add(new Node(s, 0, 0));
			Node top;
			int from, to, fuel, cost, distance;
			while(!pq.isEmpty()){
				top=pq.poll();
				from=top.index;
				fuel=top.fuel;
				cost=top.cost;
				if(d[from][fuel]!=cost)
					continue;
				if(fuel<tank && d[from][fuel+1]>d[from][fuel]+price[from]){
					d[from][fuel+1]=d[from][fuel]+price[from];
					pq.add(new Node(from, fuel+1, d[from][fuel+1]));
				}
					
				for (int j = 0; j < adj.get(from).size(); j++) {
					to=adj.get(from).get(j).first;
					distance=adj.get(from).get(j).second;
					if(distance>fuel)
						continue;
					if(d[to][fuel-distance]>d[from][fuel]){
						d[to][fuel-distance]=d[from][fuel];
						pq.add(new Node(to, fuel-distance, d[to][fuel-distance]));	
					}
					
				}
			}
			if(d[t][0]==INF)
				System.out.println("impossible");
			else
				System.out.println(d[t][0]);
			
		}
	}
}
