import java.io.BufferedReader;
import java.io.InputStreamReader;


public class KolyaAndTanya {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long mod = 1000000007;
		long ans = 1;
		for(int i=0; i<n; i++){
			ans*=27L;
			ans%=mod;
		}
		long sub=1;
		for(int i=0; i<n; i++){
			sub*=7L;
			sub%=mod;
		}
		System.out.println(((ans+mod-sub)%mod));
		
	}
}
