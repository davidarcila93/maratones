import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class SteadyTables_STDYTAB {
	static int n,m;
	static long mod = 1000000000L;
	static int MAX = 5000;
	static long[][] comb = new long[MAX][MAX];
	static long[][] dp = new long[3000][3000];
	
	public static long sumNwithKsummands(int n, int k){
		return comb[n+k-1][k-1];
	}
	
	public static long getdp(int minSum, int rowsLeft){
		if(rowsLeft==0)
			return 1L;
		if(dp[minSum][rowsLeft]!=-1)
			return dp[minSum][rowsLeft];
		long ans = sumNwithKsummands(minSum, m)*getdp(minSum, rowsLeft-1);
		ans=ans%mod;
		if(minSum<m)
			ans=(ans+getdp(minSum+1, rowsLeft))%mod;
		return dp[minSum][rowsLeft]=ans;
	}
	
	public static void main(String[] args)throws Exception {
		for(int i=0; i<MAX; i++){
			comb[i][0]= comb[i][i]=1L;
		}
		for(int i=0; i<MAX; i++){
			for(int j=1; j<i; j++){
				comb[i][j]= (comb[i-1][j-1]+comb[i-1][j])%mod;
			}
		}
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T=sc.nextInt();
		for(int i=0; i<T; i++){
			for(int j=0; j<dp.length; j++){
				Arrays.fill(dp[j], -1L);	
			}
//			st = new StringTokenizer(br.readLine().trim());
			n = sc.nextInt();
			m = sc.nextInt();
			System.out.println(getdp(0, n));
		}
	}
}
