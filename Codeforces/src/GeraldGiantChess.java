import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class GeraldGiantChess {
	static long mod = 1000000007; 
	static long dp[][];
	static long[] x, y;
	static int n;
	static long[] fact, inv;
	
	public static long getdp(int from, int to){
		if(dp[from][to]!=-1)
			return dp[from][to];
		long ans=0;
		for(int i=1; i<=n; i++){
			if(i==from || i==to)
				continue;
			if(x[i]>= x[from] && x[i]<=x[to] && y[i]>= y[from] && y[i]<=y[to]){
				ans+=getdp(from, i)*getComb((int)(x[to]+y[to]-x[i]-y[i]), (int)(x[to]-x[i]));
				ans%=mod;
			}
		}
		ans = (getComb((int)(x[to]+y[to]-x[from]-y[from]), (int)(x[to]-x[from]))+mod-ans)%mod;
		return dp[from][to]=ans;
	}
	
	public static long getComb(int a, int b){
		return (((fact[a]*inv[b])%mod)*inv[a-b])%mod;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h, w;
		h=Integer.parseInt(st.nextToken());
		w=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		x = new long[n+2];
		y = new long[n+2];
		x[0]=y[0]=1;
		x[n+1]=h;
		y[n+1]=w;
		for(int i=1; i<=n; i++){
			st=new StringTokenizer(br.readLine());
			x[i]=Integer.parseInt(st.nextToken());
			y[i]=Integer.parseInt(st.nextToken());
		}
		
		
		fact=new long[h+w+1];
		inv=new long[h+w+1];
		fact[0]=1L;
		inv[0]=1L;
		for(int i=1; i<=h+w; i++){
			fact[i]=(fact[i-1]*i)%mod;
			inv[i]=fastPow(fact[i], mod-2);
		}
		dp = new long[n+2][n+2];
		for(int i=0; i<n+2; i++){
			Arrays.fill(dp[i], -1);
		}
		System.out.println(getdp(0, n+1));
	}
	
	public static long fastPow(long a, long n){
		if(n==0)
			return 1;
		if(n==1)
			return a;
		long aux= fastPow(a, n/2);
		aux=aux*aux;
		aux%=mod;
		if(n%2==1){
			aux*=a;
			aux%=mod;
		}
		return aux;
	}
}
