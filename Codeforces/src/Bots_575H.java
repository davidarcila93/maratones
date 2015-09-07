import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Bots_575H {
	static long mod = 1000000007;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int MAX = 2000010;
		
		long[] fact = new long[MAX];
		long[] inv = new long[MAX/2];
		
		fact[0] = 1l;
		for(int i=1; i<fact.length; i++){
			fact[i] = (fact[i-1]*i)%mod;
		}
		for(int i=0; i<inv.length; i++){
			inv[i] = fastPow(fact[i], (int)(mod-2));
		}
		long ans = ((((fact[2*n+2]*inv[n+1])%mod) *inv[n+1])+mod-1)%mod;
		
		System.out.println( ans);
	}
	
	public static long fastPow(long n, int exp){
		if(exp == 0)
			return 1;
		long ans = fastPow(n, exp/2);
		ans = (ans*ans)%mod;
		if(exp%2!=0)
			ans=(ans*n)%mod;
		return ans;
	}
}
