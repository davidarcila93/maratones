import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ColoredBalls {
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		long mod=1000000007L;
		long comb[][]=new long[1001][1001];
		for(int i=0; i<1001; i++){
			comb[i][0]=comb[i][i]=1L;
		}
		for(int i=0; i<1001; i++){
			for(int j=1; j<i; j++){
				comb[i][j]=(comb[i-1][j-1]+comb[i-1][j])%mod;
			}
		}
		int n=Integer.parseInt(br.readLine());
		long ans=1L;
		int aux;
		int balls[]=new int[n];
		aux=0;
		for(int i=n-1; i>=0; i--){
			balls[i]=Integer.parseInt(br.readLine());
			aux+=balls[i];
		}
		for(int i=0; i<n; i++){
			ans*=comb[ aux-1 ][ balls[i]-1 ];
			aux-=balls[i];
			ans%=mod;
		}
		System.out.println(ans);
		
	}
}
