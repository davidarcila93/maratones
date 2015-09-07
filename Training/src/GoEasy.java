import java.io.*;
import java.util.*;

public class GoEasy {
	
	public static class Node implements Comparable<Node>{
		int station;
		int cost;
		
		public Node(int station, int cost){
			this.station=station;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.cost!=o.cost) return this.cost-o.cost;
			return 0;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int cost[];
		int INF=1000000000;
		PriorityQueue<Node> pq;
		StringTokenizer st;
		int Z,S, aux, T, B, prev, act, X, Y;
		int s,c;
		int zone[];
		Node n;
		ArrayList<ArrayList<Integer>> byTrain;
		ArrayList<ArrayList<Integer>> byBus;
		ArrayList<Integer> temp;
		while(true){
			st=new StringTokenizer(br.readLine());
			Z=Integer.parseInt(st.nextToken());
			S=Integer.parseInt(st.nextToken());
			
			if(Z==0 && S==0)	break;
			
			byTrain=new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < S; i++) {
				temp=new ArrayList<Integer>();
				byTrain.add(temp);
			}
			
			byBus=new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < S; i++) {
				temp=new ArrayList<Integer>();
				byBus.add(temp);
			}
			
			zone=new int[S];
			for (int i = 0; i <Z ; i++) {
				st=new StringTokenizer(br.readLine());
				st.nextToken();
				while(st.hasMoreTokens()){
					aux=Integer.parseInt(st.nextToken())-1;
					zone[aux]=i;
				}
			}
			st=new StringTokenizer(br.readLine());
			T=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < T; i++) {
				st=new StringTokenizer(br.readLine());
				st.nextToken();
				act=Integer.parseInt(st.nextToken())-1;
				while(st.hasMoreTokens()){
					prev=act;
					act=Integer.parseInt(st.nextToken())-1;
					byTrain.get(act).add(prev);
					byTrain.get(prev).add(act);
				}
				
			}
			
			for (int i = 0; i < B; i++) {
				temp=new ArrayList<Integer>();
				st=new StringTokenizer(br.readLine());
				st.nextToken();
				while(st.hasMoreTokens()){
					temp.add(Integer.parseInt(st.nextToken())-1);
				}
				for (int x = 0; x < temp.size() ; x++) {
					for (int y = 0; y < temp.size(); y++) {
						byBus.get(temp.get(x)).add(temp.get(y));
						byBus.get(temp.get(y)).add(temp.get(x));
					}
				}
				
			}
			
			st=new StringTokenizer(br.readLine());
			X=Integer.parseInt(st.nextToken())-1;
			Y=Integer.parseInt(st.nextToken())-1;
			
			cost=new int[S];
			Arrays.fill(cost, INF);
			
			cost[X]=2;
			
			pq=new PriorityQueue<Node>();
			pq.add(new Node(X, 2));
			
			while(!pq.isEmpty()){
				n=pq.poll();
				s=n.station;
				c=n.cost;
				
				for (int i = 0; i < byTrain.get(s).size(); i++) {
					if(zone[s]==zone[byTrain.get(s).get(i)] && c<cost[byTrain.get(s).get(i)]){
						cost[byTrain.get(s).get(i)]=c;
						pq.add(new Node(byTrain.get(s).get(i), c));
					}
					else if(zone[s]!=zone[byTrain.get(s).get(i)] && c+4<cost[byTrain.get(s).get(i)]){
						cost[byTrain.get(s).get(i)]=c+4;
						pq.add(new Node(byTrain.get(s).get(i), c+4));
					}
				}
				
				for (int i = 0; i < byBus.get(s).size(); i++) {
					if(c+1<cost[byBus.get(s).get(i)]){
						cost[byBus.get(s).get(i)]=c+1;
						pq.add(new Node(byBus.get(s).get(i), c+1));
					}
				}
				
				
			}
			
			System.out.println(cost[Y]);
			
			
			
		}
	}

}
