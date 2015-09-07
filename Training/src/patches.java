import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class patches {
	
	static int INF=1<<30;
	static int N, C, T1, T2, iter;
	static int[] distance;
	static int[] dp;
	
	
	public static int dp(int k){
		if(k>=N+iter)
			return 0;
		if(dp[k]!=INF)
			return dp[k];
		return dp[k]=Math.min(T1+dp(nextIndex(k, T1)), T2+dp(nextIndex(k, T2)));
	}
	
	public static int nextIndex(int k, int T){
		int act=k;
		
		while(distance[act]-distance[k]<=T){
			act++;
			if(act>=2*N)
				return act;
		}
		return act;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		while((str=br.readLine())!=null){
			st=new StringTokenizer(str);
			N=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			T1=Integer.parseInt(st.nextToken());
			T2=Integer.parseInt(st.nextToken());
			distance=new int[2*N];
			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				distance[i]=Integer.parseInt(st.nextToken());
			}
			for (int i = N; i < 2*N; i++) {
				distance[i]=distance[i-N]+C;
			}
			
			dp=new int[2*N];
			
			int min=INF;
			for (iter = 0; iter < N; iter++) {
				Arrays.fill(dp, INF);
				min=Math.min(min, dp(iter));
			}
			System.out.println(min);
			
			
			
			
		}
		
		
	}
}
