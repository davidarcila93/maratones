import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class JoiningCouples_1302 {
	
	static ArrayList<ArrayList<Integer>> adj;
	
	static class Pair implements Comparable<Pair>{
		
		int node;
		int dist;
		
		public Pair(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Pair o) {
			return o.dist - this.dist;
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		int n;
		PriorityQueue<Pair> pq;
		int dist[];
		while((str = br.readLine())!=null){
			n = Integer.parseInt(str);
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<n; i++){
				adj.add(new ArrayList<Integer>());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++){
				adj.get(Integer.parseInt(st.nextToken())- 1).add(i);
			}
			dist = new int[n];
			Arrays.fill(dist, -1);
		}
	}

}
