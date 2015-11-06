import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class URI_1580 {
	
	static long mod = 1000000007L;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int v[] = new int[26];
		long fact[] = new long[1010];
		long inv[] = new long[1010];
		fact[0]=1;
		for(int i=1; i<1010; i++){
			fact[i] = (fact[i-1]*i)%mod;
		}
		for(int i=0; i<1010; i++){
			inv[i] = fastPow(fact[i], (int)(mod-2));
		}
		long ans;
		while((str = br.readLine())!=null){
			Arrays.fill(v, 0);
			for(int i=0; i<str.length(); i++){
				v[ str.charAt(i)-'A' ]++;
			}
			ans = fact[str.length()];
			for(int i=0; i<26; i++){
				ans = (ans*inv[v[i]])%mod;
			}
			System.out.println(ans);
		}
	}
	
	static long fastPow(long a, int exp){
		long ans =1;
		if(exp == 0)
			return 1;
		if(exp == 1)
			return a;
		ans = fastPow(a, exp/2);
		ans = ans*ans;
		ans%=mod;
		if(exp%2==1){
			ans*=a;
			ans%=mod;
		}
		return ans;
		
	}

}
