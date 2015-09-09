import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class VotingDuels_12949 {
	
	static ArrayList<ArrayList<Integer>> adj, tie;
	static 	boolean visited[];
	
	public static void dfs(int node){
		if( visited[node] )
			return;
		visited[node]=true;
		ArrayList<Integer> list = adj.get(node);
		for(int i=0; i<list.size(); i++){
			dfs( list.get(i) );
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		int[] votes;
		int[][] preference;
		String s;
		
		int votesa, votesb;
	
		while( (str = br.readLine())!=null ){
			st = new StringTokenizer(str);
			int n , b, c;
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = st.nextToken().charAt(0)-'a';
			votes = new int[b];
			preference = new int[b][n];
			
			for(int i=0; i<b; i++){
				st = new StringTokenizer(br.readLine());
				votes[i] = Integer.parseInt(st.nextToken());
				s = st.nextToken();
				for(int j=0; j<n; j++){
					preference[i][ s.charAt(j) - 'a' ] = j;
				}
			}
			
			adj = new ArrayList<ArrayList<Integer>>();
			tie = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<n; i++){
				adj.add(new ArrayList<Integer>());
				tie.add(new ArrayList<Integer>());
			}
			for(int i=0; i<n; i++){
				for(int j=i+1; j<n; j++){
					votesa=0;
					votesb=0;
					for(int k=0; k<b; k++){
						if( preference[ k ][ i ] < preference[ k ][ j ] )
							votesa += votes[k];
						else
							votesb += votes[k];
					}
					if(votesa==votesb){
						tie.get(i).add(j);
						tie.get(j).add(i);
					}else if(votesa>votesb)
						adj.get(i).add(j);
					else
						adj.get(j).add(i);
				}
			}
			
			visited = new boolean[n];
			dfs(c);
			for(int i=0; i<tie.get(c).size(); i++){
				dfs(tie.get(c).get(i));
			}
			boolean can = true;
			for(int i = 0; i<n && can; i++){
				if(!visited[i])
					can=false;
			}
			if(can)
				System.out.println("Y");
			else
				System.out.println("N");
			
		}
	}
}
