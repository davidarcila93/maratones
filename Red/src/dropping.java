import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class dropping {

	public static boolean visited[];
	public static ArrayList<ArrayList<Integer>> adj;
	
	public static class Pair implements Comparable<Pair>{

		int x, y;
		
		public Pair(int x , int y) {
			this.x = Math.min(x, y);
			this.y = Math.max(x, y);
		}
		public int compareTo(Pair o) {
			if(this.x != o.x)
				return this.x-o.x;
			return this.y-o.y;
		}
		
	}
	
	public static void dfs(int node){
		if(visited[node])
			return;
		visited[node] = true;
		ArrayList<Integer> list = adj.get(node);
		for(int i=0; i<list.size(); i++){
			dfs(list.get(i));
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long max = 1006000;
		int n, g;
		int id;
		int a, b, c, d;
		int ida, idb, idc, idd;
		Pair aux;
		
		int next[];
		TreeMap<Pair, Integer> map;
		while(T-->0){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			map = new TreeMap<Pair, Integer>();
			id = 0;
			adj = new ArrayList<ArrayList<Integer>>();
			next = new int[4];
			for(int i =1; i<= n; i++){
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				
				aux = new Pair(a, i);
				if( map.containsKey(aux) )
					ida = map.get(aux);
				else{
					ida = id;
					map.put(aux, id++);
					adj.add(new ArrayList<Integer>());
				}

				aux = new Pair(b, i);
				if( map.containsKey(aux) )
					idb = map.get(aux);
				else{
					idb = id;
					map.put(aux, id++);
					adj.add(new ArrayList<Integer>());
				}
				
				aux = new Pair(c, i);
				if( map.containsKey(aux) )
					idc = map.get(aux);
				else{
					idc = id;
					map.put(aux, id++);
					adj.add(new ArrayList<Integer>());
				}
				
				aux = new Pair(d, i);
				if( map.containsKey(aux) )
					idd = map.get(aux);
				else{
					idd = id;
					map.put(aux, id++);
					adj.add(new ArrayList<Integer>());
				}
				if( i == g ){
					next[0] = ida;
					next[1] = idb;
					next[2] = idc;
					next[3] = idd;
				}
				
				adj.get(ida).add(idb);
				adj.get(idb).add(ida);
				adj.get(idc).add(idd);
				adj.get(idd).add(idc);
			}
			
			visited = new boolean[id];
			Arrays.fill(visited, false);
			int cc = 0;
			for(int i=0; i<4; i++){
				dfs(next[i]);
			}
			for(int i=0; i<id; i++){
				if(!visited[i]){
					cc++;
					dfs(i);
				}
			}
			System.out.println(cc);
			
		}
	}

}
