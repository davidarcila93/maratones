import java.io.*;
import java.util.*;

public class Main_FullTank {
	static int n;
	static int[] price;
	static ArrayList<ArrayList<Pair>> adj;
	static int[] d;
	static int INF=1<<30;
	static int s, t, tank;
	static PriorityQueue<Node> pq;
	static LinkedList<Pair> aux;
	
 	public static class Pair{
		int first;
		int second;
		Pair(int first, int second){
			this.first=first;
			this.second=second;
		}
		@Override
		public String toString() {
		
			return first+"--"+second;
		}
	}
	public static class Node implements Comparable<Node>{
		int index;
		int cost;
		LinkedList<Pair> list;
		Node(int index, int cost, LinkedList<Pair> list){
			this.index=index;
			this.cost=cost;
			this.list=list;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
		@Override
		public String toString() {
			return index+"--"+cost+"--"+list.toString();
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int m, a, b, c, q;
		st=new StringTokenizer(br.readLine().trim());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		price=new int[n];
		st=new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			price[i]=Integer.parseInt(st.nextToken());
		}
		adj=new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < m; i++) {
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
			d=new int[n];
			Arrays.fill(d, INF);
			pq=new PriorityQueue<Node>();
			d[t]=0;
			aux=new LinkedList<Pair>();
//			aux.add(new Pair(tank, price[s]));
			pq.add(new Node(t, 0, aux));
			Node top;
			LinkedList<Pair> list, listaux;
			Pair temp;
			int from, to, distance, cost, tempcost, distance2, refill;
			int pa, pb;
			while(!pq.isEmpty()){
				top=pq.poll();
				from=top.index;
				cost=top.cost;
				list=top.list;
				if(d[from]!=cost)
					continue;
				for (int j = 0; j < adj.get(from).size(); j++) {
					to=adj.get(from).get(j).first;
					distance=adj.get(from).get(j).second;
					if(distance>tank)
						continue;
					distance2=distance;
					tempcost=cost+distance*price[to];
					listaux=new LinkedList<Pair>(list);
					while(distance2<tank && !listaux.isEmpty()){
						temp=listaux.removeFirst();
						pa=temp.first;
						pb=temp.second;
						if(pb<price[to])
							break;
						if(pa>(tank-distance2)){
							listaux.addFirst(new Pair(pa-(tank-distance2), pb));
							tempcost-=(tank-distance2)*(pb-price[to]);
							distance2=tank;
						}
						else{
							tempcost-=pa*(pb-price[to]);
							distance2+=pa;
						}
					}
					listaux.addFirst(new Pair(distance2, price[to]));
//					refill=distance;
//					while(!listaux.isEmpty()){
//						temp=listaux.peekLast();
//						pa=temp.first;
//						pb=temp.second;
//						if(pb<price[to])
//							break;
//						else{
//							listaux.removeLast();
//							refill+=pa;
//						}
//					}
//					listaux.addLast(new Pair(refill, price[to]));
					if(d[to]>tempcost){
						d[to]=tempcost;
						pq.add(new Node(to, d[to], listaux));
					}
						
				}
			}
			if(d[s]==INF)
				System.out.println("impossible");
			else
				System.out.println(d[s]);
		}
	}
}
