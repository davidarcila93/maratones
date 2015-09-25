import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ToebaldosTrip_10681 {
	
	static ArrayList<ArrayList<Integer>> adj;
	static int v[][];
	
	public static void dfs(int n, int dist){
		if(dist>200)
			return;
		if( v[n][dist] == 1  )
			return;
		v[n][dist] = 1;
		ArrayList<Integer> list = adj.get(n);
		for(int i=0; i<list.size(); i++){
			dfs( list.get(i), dist+1);
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int c, l;
		int s, e, d;
		
		int a, b;
		while( (str = br.readLine() )!=null ){
			st = new StringTokenizer(str);
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			if( l==0 && c ==0)
				return;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<c; i++){
				adj.add(new ArrayList<Integer>());
			}
			v = new int[c][201];
			for(int i=0; i<l; i++){
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken())-1;
				b = Integer.parseInt(st.nextToken())-1;
				adj.get(a).add(b);
				adj.get(b).add(a);
			}
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken())-1;
			e = Integer.parseInt(st.nextToken())-1;
			d = Integer.parseInt(st.nextToken());
			
			dfs(s, 0);
			
			if( v[e][d] == 1 )
				System.out.println("Yes, Teobaldo can travel.");
			else
				System.out.println("No, Teobaldo can not travel.");
				
			br.readLine();
		}
	}

}
