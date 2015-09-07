import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;


public class divisions {
	
	static boolean prime[];
	static long MAX = 1000000l+10l;
	static ArrayList<Integer> primes;
	static void sieve(){
		prime = new boolean[(int)MAX];
		Arrays.fill(prime, true);
		prime[0]=prime[1]=false;
		primes = new ArrayList<Integer>();
		primes.add(2);
		for(int i=3; i<MAX; i+=2){
			if(!prime[i])continue;
			primes.add(i);
			if(i>1000)
				continue;
			for(int aux = i*i; aux<MAX; aux+=i){
				prime[aux]=false;
			}
		}
	}
	
	public static int divisors(long n){
		if(n==1)return 1;
		int ans=1;
		int aux = 1;
		while(n%2==0){
			n/=2;
			aux++;
		}
		ans*=aux;
		for(int div = 3; div<1000001; div+=2){
			aux=1;
			while(n%div==0){
				n/=div;
				aux++;
			}
			ans*=aux;
		}
		if(n==1)
			return ans;
		BigInteger b = new BigInteger(""+n);
		if(b.isProbablePrime(20))
			return ans*2;
		long sq = (long)Math.sqrt(n);
		if(sq*sq==n || (sq+1)*(sq+1)==n)
			return ans*3;
		return ans*4;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n;
		n = Long.parseLong(br.readLine());
		sieve();
		System.out.println(divisors(n));
	}

}
