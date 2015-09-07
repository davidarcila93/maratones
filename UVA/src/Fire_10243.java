import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Fire_10243 {
	
	static int[][] dp;
	static int[] id;
	static ArrayList<ArrayList<Integer>> adj;
	static int val;
//	static int p=0;
	/*State
	 *  0 puedo marcar o no
	 *  1 debo marcar
	 */
	
	public static int getdp(int n, int state){
		if(dp[n][state]!=-1)
			return dp[n][state];
		ArrayList<Integer> aux;
		int ans=Integer.MAX_VALUE;
		aux = adj.get(n);
		int tmp = 1;
		for(int i=0; i<aux.size(); i++){
			if(id[aux.get(i)]<id[n])
				continue;
			tmp+=getdp(aux.get(i), 0);
		}
		ans = Math.min(ans, tmp);
		if(state == 0){
			tmp=0;
			for(int i=0; i<aux.size(); i++){
				if(id[aux.get(i)]<id[n])
					continue;
				tmp+=getdp(aux.get(i), 1);
			}
			ans = Math.min(ans, tmp);
		}
		return dp[n][state]=ans;
	}
	
	public static void visit(int node){
//		System.out.println("node "+node+" val "+val);
		id[node]=val++;
		ArrayList<Integer> aux = adj.get(node);
		for(int i=0; i<aux.size(); i++){
			if(id[aux.get(i)]!=-1)
				continue;
			visit(aux.get(i));
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int N;
		int k;
		
		 
		ArrayList<Integer> aux;
		while((str=br.readLine())!=null){
			N=Integer.parseInt(str);
			if(N==0)
				return;
			adj= new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<N; i++){
				aux= new ArrayList<Integer>();
				st= new StringTokenizer(br.readLine());
				k=Integer.parseInt(st.nextToken());
				for(int j=0; j<k; j++){
					int a = Integer.parseInt(st.nextToken())-1;
					aux.add(a);
				}
				adj.add(aux);
			}
			
			dp = new int[N][2];
			for(int i=0; i<N; i++){
				Arrays.fill(dp[i], -1);	
			}
			id = new int[N];
			Arrays.fill(id, -1);
			val=0;
			visit(0);
			if(N==1)
				System.out.println("1");
			else
				System.out.println(getdp(0, 0));
		}
	}
}	
