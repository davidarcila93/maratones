import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_Planets {
	
	static ArrayList<ArrayList<Node>> ady;
	static ArrayList<ArrayList<Event>> E;
	static boolean[] visited;
	static int[] distance;
	static PriorityQueue<Node> Q;
	static int INF=1<<30;
	
	static class Node implements Comparable<Node>{
		int index;
		int cost;
		Node(int index, int cost){
			this.index=index;
			this.cost=cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
		
		@Override
		public String toString() {
			return index+"--> "+cost;
		}
	}
	
	static class Event implements Comparable<Event>{
		int start;
		int end;
		Event(int start, int end){
			this.start=start;
			this.end=end;
		}
		@Override
		public int compareTo(Event o) {
			if(this.start!=o.start)
				return this.start-o.start;
			return this.end-o.end;
		}
		@Override
		public String toString() {
			return "start: "+start+" --end: "+end;
		}
	}
	
	static int BS(int from, int cur){
		int lo, hi, mid;
		if(E.get(from).size()==0)
			return -1;
		lo=0;
		hi=E.get(from).size()-1;
		int loval, hival, midval;
		hival=E.get(from).get(hi).start;
		loval=E.get(from).get(lo).start;
		while(lo<hi-1){
			mid=(lo+hi)/2;
			midval=E.get(from).get(mid).start;
			if(midval>cur){
				hi=mid-1;
				hival=E.get(from).get(hi).start;
			}
			else{
				lo=mid;
				loval=midval;
			}
		}
		if(hival<=cur)
			return hi;
		return lo;
	}
	
	public static void Dijkstra(int init){
		Q=new PriorityQueue<Node>();
		Q.add(new Node(init, 0));
		distance[init]=0;
		int from, to, cur,cost, aditional;
		int p;
		while(!Q.isEmpty()){
			from=Q.peek().index;
			cur=Q.peek().cost;
			Q.remove();
			
			p=BS(from, cur);
			if(visited[from])
				continue;
			visited[from]=true;
			if(p==-1)
				aditional=0;
			else
				aditional=Math.max(0, E.get(from).get(p).end-cur);
			for (int i = 0; i < ady.get(from).size(); i++) {
				to=ady.get(from).get(i).index;
				cost=ady.get(from).get(i).cost+aditional;
				
				if(!visited[to])
					relaxation(from, to, cost);
				
				
			}
			
		}
	}
	
	public static void relaxation(int from, int to, int cost){
		if(distance[from]+cost<distance[to]){
			distance[to]=distance[from]+cost;
			Q.add(new Node(to, distance[to]));
		}
			
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n, m;
		int a, b, c;
		int times;
		ArrayList<Node> aux;
		ArrayList<Event> aux2;
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		ady=new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < n; i++) {
			aux=new ArrayList<Node>();
			ady.add(aux);
		}
		visited=new boolean[n];
		distance=new int[n];
		for (int i = 0; i < n; i++) {
			distance[i]=INF;
		}
		E=new ArrayList<ArrayList<Event>>();
		for (int i = 0; i < n; i++) {
			aux2=new ArrayList<Event>();
			E.add(aux2);
		}
		for (int i = 0; i < m; i++) {
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken())-1;
			b=Integer.parseInt(st.nextToken())-1;
			c=Integer.parseInt(st.nextToken());
			ady.get(a).add(new Node(b, c));
			ady.get(b).add(new Node(a, c));
		}
		for (int i = 0; i < n; i++) {
			st=new StringTokenizer(br.readLine());
			times=Integer.parseInt(st.nextToken());
			a=-1;
			b=-1;
			for (int j = 0; j < times; j++) {
				c=Integer.parseInt(st.nextToken());
				if(c==b)
					b++;
				else{
					E.get(i).add(new Event(a, b));
					a=c;
					b=a+1;
				}
				if(j==times-1)
					E.get(i).add(new Event(a, b));
					
			}
		}
		Dijkstra(0);
		
		if(distance[n-1]==(1<<30))
			System.out.println("-1");
		else
			System.out.println(distance[n-1]);
		
		
		
	}
}
