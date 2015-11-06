import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class f {
	
	static int dp[][];// i last team, j current city
	static ArrayList<ArrayList<Integer>> adj, aux;
	static boolean seen[];
	static int d[][];
	static int team[];
	static int n, e;
	
	static void dfs(int node){
		seen[node] = true;
		ArrayList<Integer> list = aux.get(node);
		for(int i=0; i<list.size(); i++){
			if( !seen[list.get(i)] ){
				adj.get(node).add(list.get(i));
				dfs(list.get(i));
			}
		}
	}
	
	static int getdp(int last, int cur){
		if( last != -1 && dp[last][cur]!=-1)
			return dp[last][cur];
		int ans = 1000000000;
		int tmp;
		if( team[cur] != -1 ){
			if(last != -1)
				ans = d[last][ team[cur] ];
			else
				ans = 0;
			ArrayList<Integer> list = adj.get(cur);
			for(int i=0; i<list.size(); i++){
				ans+= getdp(team[cur], list.get(i));
			}
			if(last!=-1)
				dp[last][cur] = ans;
			return ans;
		}else{
			for(int t=0; t<e; t++){
				if(last != -1)
					tmp = d[last][ t ];
				else
					tmp = 0;
				ArrayList<Integer> list = adj.get(cur);
				for(int i=0; i<list.size(); i++){
					tmp+= getdp(t, list.get(i));
				}
				ans = Math.min(ans, tmp);
			}
			if(last!=-1)
				dp[last][cur] = ans;
			return ans;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		d = new int[e][e];
		for(int i=0; i<e; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<e; j++){
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count;
		team = new int[n];
		Arrays.fill(team, -1);
		for(int i=0; i<e; i++){
			st = new StringTokenizer(br.readLine());
			count = Integer.parseInt(st.nextToken());
			for(int j=0; j<count;j++){
				team[ Integer.parseInt(st.nextToken())-1 ] = i;
			}
		}
		aux = new ArrayList<ArrayList<Integer>>();
		adj = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<n; i++){
			aux.add(new ArrayList<Integer>());
			adj.add(new ArrayList<Integer>());
		}
		int a, b;
		for(int i=0; i<n-1; i++){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			aux.get(a).add(b);
			aux.get(b).add(a);
		}
		seen = new boolean[n];
		dfs(0);
		dp = new int[e][n];
		for(int i=0; i<e; i++){
			Arrays.fill(dp[i], -1);
		}
		System.out.println(getdp(-1, 0));
	}

}
