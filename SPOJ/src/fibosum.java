import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class fibosum {
	
	static final long mat[][]={{0, 1},{1, 1}};
	static final long mod=1000000007;
	static long[][] tmp=new long[2][2];
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		for(int i=0; i<10; i++){
//			System.out.println(getFibo(i));
//		}
		int m=Integer.parseInt(br.readLine());
		while(m>0){
			m--;
			st=new StringTokenizer(br.readLine());
			System.out.println( (- getFibo(2+Integer.parseInt(st.nextToken())) + getFibo(3+Integer.parseInt(st.nextToken()))+mod)%mod  );
		}
	}
	
	public static long getFibo(int k){
		if(k<=0)
			return 0;
		long fibo[][] = new long[][]{{0,1},{1,1}};
		long ans[][] = new long[][]{{1,0},{0,1}};
		while(k>0){
			if((k&1)==1)
				multiply(ans, fibo);
			multiply(fibo, fibo);
			k>>=1;
		}
		return ans[0][0];
	}
	
	public static void multiply(long[][] a, long[][] b){
		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				tmp[i][j]=0;
				for(int k=0; k<2; k++){
					tmp[i][j]+= a[i][k]*b[k][j];
				}
				tmp[i][j]%=mod;
			}
		}
		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				a[i][j]=tmp[i][j];
			}
		}
	}
}
