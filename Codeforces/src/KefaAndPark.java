import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class KefaAndPark {
	
	static int[] maxConsec, curConsec, visited;
	static int ans;
	static ArrayList<ArrayList<Integer>> adj;
	static ArrayList<ArrayList<Integer>> children;
	static int cat[];
	static int m;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adj = new ArrayList<ArrayList<Integer>>();
		children= new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i<n; i++){
			adj.add(new ArrayList<Integer>());
		}
		for(int i = 0; i<n; i++){
			children.add(new ArrayList<Integer>());
		}
		cat = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			cat[i] = Integer.parseInt(st.nextToken());
		}
		int a, b;
		for(int i=0; i<n-1; i++){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		ans = 0;
		maxConsec = new int[n];
		curConsec = new int[n];
		curConsec[0] = maxConsec[0] = cat[0];
		visited = new int[n];
		Arrays.fill(visited, -1);
		dfs(0);
//		System.out.println(children.toString());
		visit(0);
		
//		for(int i=0; i<n; i++){
//			System.out.println(i+" "+maxConsec[i]+" "+curConsec[i]);
//		}
		System.out.println(ans);
	}
	
	public static void dfs(int node){
		visited[node] = 1;
		ArrayList<Integer> list = adj.get(node);
		for(int i=0; i<list.size(); i++){
			if(visited[list.get(i)] == -1){
				children.get(node).add(list.get(i));
				dfs(list.get(i));
			}
		}
	}
	
	public static void visit(int node){
		ArrayList<Integer> list = children.get(node);
//		System.out.println(list);
		if( list.isEmpty()){
//			System.out.println(" **** "+node);
			if(maxConsec[node]<=m)
				ans++;
		}
			
			
		int to;
		for(int i=0; i<list.size(); i++){
			to = list.get(i);
			if( cat[node] == 1 && cat[to]==1)
				curConsec[to] = curConsec[node]+1;
			else
				curConsec[to] = cat[to];
			maxConsec[to] = Math.max(maxConsec[node], curConsec[to]);
			visit(to);
		}
	}
}
