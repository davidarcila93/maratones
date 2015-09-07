import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_LiftHopping {
	
	static PriorityQueue<Node> Q;
	static ArrayList<ArrayList<Integer>> elevator;
	static ArrayList<ArrayList<Node>> ady;
	static boolean[] visited;
	static int[] distance;
	static int[] speed;
	static int INF=1<<30;

	public static class Node implements Comparable<Node>{
		int floor;
		int time;
		public Node(int floor, int time){
			this.floor=floor;
			this.time=time;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.time-o.time;
		}
		
		@Override
		public String toString() {
			
			return floor+" --> "+time;
		}
	}
	
	public static void relaxation(int from, int to, int weight){
		if(distance[from]+weight<distance[to]){
			distance[to]=distance[from]+weight;
			Q.add(new Node(to, distance[to]));
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n, k;
		String str;
		while((str=br.readLine())!=null){
			st=new StringTokenizer(str);
			n=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			speed=new int[n];
			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < speed.length; i++) {
				speed[i]=Integer.parseInt(st.nextToken());
			}
			ady=new ArrayList<ArrayList<Node>>();
			ArrayList<Integer> aux;
			elevator=new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < n; i++) {
				st=new StringTokenizer(br.readLine());
				aux=new ArrayList<Integer>();
				while(st.hasMoreTokens()){
					aux.add(Integer.parseInt(st.nextToken()));
				}
				elevator.add(aux);
			}
			ArrayList<Node> temp;
			for (int i = 0; i < 100; i++) {
				temp=new ArrayList<Node>();
				ady.add(temp);
			}
			int floora,floorb;
			for (int i = 0; i < elevator.size(); i++) {
				for (int a = 0; a < elevator.get(i).size(); a++) {
					for (int b = a+1; b < elevator.get(i).size(); b++) {
						floora=elevator.get(i).get(a);
						floorb=elevator.get(i).get(b);
						ady.get(floora).add(new Node(floorb, Math.abs(floora-floorb)*speed[i]+60));
						ady.get(floorb).add(new Node(floora, Math.abs(floora-floorb)*speed[i]+60));
					}
				}
			}
			
			
			
			Q=new PriorityQueue<Node>();
			visited=new boolean[100];
			distance= new int[100];
			for (int i = 0; i < 100; i++) {
				visited[i]=false;
				distance[i]=INF;
			}
			
			Q.add(new Node(0, 0));
			distance[0]=0;
			int from, to, weight;
			while(!Q.isEmpty()){
				from=Q.peek().floor;
				Q.remove();
				if(visited[from])
					continue;
				visited[from]=true;
				for (int i = 0; i < ady.get(from).size(); i++) {
					to=ady.get(from).get(i).floor;
					weight=ady.get(from).get(i).time;
					if(!visited[to]){
						relaxation(from, to, weight);
					}
				}
			}
			if(distance[k]==(1<<30))
				System.out.println("IMPOSSIBLE");
			else if(k==0)
				System.out.println("0");
			else
				System.out.println(distance[k]-60);
		}
		
		
	}
}
