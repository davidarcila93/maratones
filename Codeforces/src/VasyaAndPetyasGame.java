import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class VasyaAndPetyasGame {
	static int MAX = 1010;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean prime[] = new boolean[MAX];
		Arrays.fill(prime, true);
		prime[0]=false;
		prime[1]=false;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i=2; i<MAX; i++){
			if(!prime[i])
				continue;
			primes.add(i);
			for(int j = i*i; j<MAX; j+=i){
				prime[j] = false;
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for(int k: primes){
			int aux = k;
			while( aux <= n){
				ans.add(aux);
				aux*=k;
			}
		}
		System.out.println(ans.size());
		for(int i=0; i<ans.size(); i++){
			if(i!=0)
				System.out.print(" ");
			System.out.print(ans.get(i));
		}
		System.out.println();
	}
}
