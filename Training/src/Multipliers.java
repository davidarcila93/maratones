import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Multipliers {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long mod=1000000007;
		int n, a, d;
		long comb[][];
		TreeMap<Integer, Integer> factors=new TreeMap<Integer, Integer>();
		n=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		
		factors.put(2, 0);
		for (int i = 0; i < n; i++) {
			a=Integer.parseInt(st.nextToken());
			
			d=2;
			while((a%d)==0){
				a=a/2;
				factors.put(d, factors.get(d)+1);
			}
			
			d=3;
			while(d<Math.sqrt(a+1)){
				while((a%d)==0){
					a=a/d;
					if(factors.containsKey(d))
						factors.put(d, factors.get(d)+1);
					else factors.put(d, 1);
					
					
				}
				d+=2;
			}
			if(a!=1){
				if(factors.containsKey(a))
					factors.put(a, factors.get(a)+1);
				else factors.put(a, 1);
			}
		}
		
		comb=new long[32][32];
		
		for (int i = 0; i < 32; i++) {
			comb[i][i]=comb[i][0]=1l;
		}
		
		for (int i = 0; i < 32; i++) {
			for (int j = 1; j < i; j++) {
				comb[i][j]=(comb[i-1][j-1]+comb[i-1][j])%mod;
			}
		}
		
		long ans=1l;
		for(int k: factors.keySet()){
			ans=(ans*comb[n+factors.get(k)-1][n-1])%mod;
		}
		
		System.out.println(ans);
		
	}

}
