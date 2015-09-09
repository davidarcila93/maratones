import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class GragileBridges_201C {
	
	
	static long dp[][];
	static int n;
	static long[] v;
	
	public static long getdp(int state, int pos){
		if( dp[state][pos]!=-1L)
			return dp[state][pos];
		if(pos==n-1)
			return 0;
		long ans = 0L; 
		if(state == 0 ){
			ans = Math.max(ans, getdp(0, pos+1));
			ans = Math.max(ans, v[pos]/2*2+getdp(1, pos+1));
			ans = Math.max(ans, (v[pos]%2 == 0 ? v[pos]-1 : v[pos]) + getdp(2, pos+1));
			return dp[state][pos]=ans;
		}
		else if(state == 1){
			if(v[pos]!=1)
				ans = Math.max(ans, v[pos]/2*2+getdp(1, pos+1));
			ans = Math.max(ans, (v[pos]%2 == 0 ? v[pos]-1 : v[pos]) + getdp(2, pos+1));
			return dp[state][pos]=ans;
		}
		else if(state==2){
			ans = Math.max(ans, (v[pos]%2 == 0 ? v[pos]-1 : v[pos]) + getdp(2, pos+1));
			ans = Math.max(ans, v[pos]/2*2+getdp(3, pos+1));
			return dp[state][pos]=ans;
		}else{
			if(v[pos]!=1)
				ans = Math.max(ans, v[pos]/2*2+getdp(3, pos+1));
			return dp[state][pos]=ans;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = new long[n-1];
		long aux;
		int idmin=-1, idmax=-1;
		for(int i=0; i<n-1; i++){
			aux = Long.parseLong(st.nextToken());
			v[i] = aux;
			if(v[i]==1){
				idmax = i;
				if(idmin==-1)
					idmin = i;
			}
		}
		dp = new long[4][n];
		for(int i=0; i<4; i++){
			Arrays.fill(dp[i], -1L);
		}
		System.out.println(getdp(0, 0));
	}

}
