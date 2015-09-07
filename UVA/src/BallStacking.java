import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BallStacking {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		n =Integer.parseInt(br.readLine());
		long stack[][];
		long acu[][];
		long dp[][];
		long aux;
		while(n!=0){
			stack = new long[n][n];
			acu = new long[n][n+1];
			for(int i=0; i<n; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<=i; j++){
					aux = Long.parseLong(st.nextToken());
					stack[n-1-j][i-j]=aux;
				}
			}
			for(int i=0; i<n; i++){
				for(int j=0; j<=i; j++){
					acu[i][j+1] = acu[i][j]+stack[i][j];
				}
			}
			
			dp = new long[n][n+1];
			dp[0][0]=0;
			dp[0][1]=Math.max(0, stack[0][0]);
			
			for(int i=1; i<n; i++){
				dp[i][0]=0;
				for(int j=1; j<=i+1; j++){
					dp[i][j] = Math.max(dp[i][j-1], acu[i][j]+dp[i-1][ Math.min(j, i) ]);
				}
			}
			
			System.out.println(dp[n-1][n]);
			
//			System.out.println("STACK");
//			for(int i=0; i<n; i++){
//				System.out.println(Arrays.toString(stack[i]));
//			}
//			System.out.println("ACU");
//			for(int i=0; i<n; i++){
//				System.out.println(Arrays.toString(acu[i]));
//			}
//			System.out.println("DP");
//			for(int i=0; i<n; i++){
//				System.out.println(Arrays.toString(dp[i]));
//			}
			n =Integer.parseInt(br.readLine());	
		}
		
	}
}
