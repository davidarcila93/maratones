import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SymmetricAndTransitive {
	
	static long mod = 1000000007;;
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long comb[][] = new long[n+1][n+1];
		for(int i=0; i<comb.length; i++){
			comb[i][i]=comb[i][0]=1;
		}
		for(int i=0; i<comb.length; i++){
			for(int j=1; j<i; j++){
				comb[i][j]=(comb[i-1][j-1]+comb[i-1][j])%mod;
			}
		}
//		long two[] = new long[n+1];
//		two[0]=1;
//		for(int i=1; i<two.length; i++){
//			two[i]=(two[i-1]*2)%mod;
//		}
		long bell[] = new long[n+1];
		bell[0]=1;
		for(int i=0; i<bell.length-1; i++){
			for(int k=0; k<=i; k++){
				bell[i+1] += (comb[i][k]*bell[k])%mod;
				bell[i+1]%=mod;
			}
		}
//		System.out.println(bell[0]);
//		System.out.println(bell[1]);
//		System.out.println(bell[2]);
		long ans = 0;
		for(int i=1; i<=n; i++){
			long aux = (comb[n][i]*bell[n-i])%mod;
//			System.out.println("******** "+aux);
//			if(i%2==0) aux*=-1;
			ans=(ans+aux)%mod;
//			ans=(ans+mod)%mod;
		}
		System.out.println(ans);
		
	}
}
