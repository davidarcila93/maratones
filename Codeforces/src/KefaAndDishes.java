import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class KefaAndDishes {
	
	static int n, m ,k;
	static long[][] dp;
	static long[] val;
	static long[][] map;
	
	public static long getdp(int cur, int mask){
		if( cur != -1 && dp[cur][mask] != -1L )
			return dp[cur][mask];
		if(Integer.bitCount(mask)== m)
			return 0;
		long ans = 0L;
		long aux;
		for( int i=0; i<n; i++ ){
			if( (mask & (1<<i)) != 0 )
				continue;
			ans = Math.max(ans, (cur==-1? 0 : map[cur][i]) + val[i] + getdp(i, mask | (1<<i)));
		}
		if(cur!=-1)
			dp[cur][mask] = ans;
		return ans;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		val = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			val[i] = Long.parseLong(st.nextToken());
		}
		
		map = new long[n][n];
		for(int i =0; i<k; i++){
			st = new StringTokenizer(br.readLine());
			map[ Integer.parseInt(st.nextToken())-1 ][ Integer.parseInt(st.nextToken())-1 ] = Long.parseLong(st.nextToken()); 
		}
		
		dp = new long[n][1<<n];
		
		for(int i=0; i<n; i++){
			Arrays.fill(dp[i], -1L);
		}
		
		System.out.println(getdp(-1, 0));
	}
}
