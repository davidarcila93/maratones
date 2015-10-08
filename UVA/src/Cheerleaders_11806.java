import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Cheerleaders_11806 {
	
	static int mod = 1000007;
	static int comb[][];
	static int MAX = 510;
	
	public static int getComb(int n, int k){
		if(k>n)
			return 0;
		return comb[n][k];
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		comb = new int[MAX][MAX];
		
		for(int i=0; i<MAX ; i++){
			comb[i][0] = comb[i][i] = 1;
		}

		for(int i=0; i<MAX ; i++){
			for(int j=1; j<i; j++){
				comb[i][j] = ( comb[i-1][j-1] +  comb[i-1][j] )%mod;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		int ans;
		int n, m, k;
		StringTokenizer st;
		for(int c=1; c<=T; c++){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			ans = getComb(n*m, k);
			ans -= 2*(getComb(n*m-m, k) +  getComb(n*m-n, k) );
			ans += getComb(n*m - n - n, k) + getComb(n*m-m-m, k) + 4*getComb(n*m -n-m+1, k);
			ans -= 2*( getComb(n*m -n -n -m +2, k) + getComb(n*m -n -m -m +2, k) );
			ans += getComb((n-2)*(m-2), k);
			ans += 100*mod;
			ans %= mod;
			System.out.println("Case "+c+": "+ans);
		}
	}

}
