import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class DuffinBeach {
	
	static long mod = 1000000007;
	static long lis[][]; 
	static int n;
	static long l;
	static int k;
	static int[] v;
	
	public static long getLis( int id, int count ){
		if(count == k)
			return 1;
		if(lis[id][count]!=-1)
			return lis[id][count];
		long ans = 1;
		for(int i=0; i<n && i+count*n<l; i++){
			if( v[id]<=v[i] ){
				ans+=getLis(i, count+1);
				ans%=mod;
			}
		}
		return lis[id][count] = ans;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Long.parseLong(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		lis = new long[n][k];
		for(int i=0; i<n; i++){
			Arrays.fill(lis[i], -1);
		}
		v = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		long ans = 0;
		for(int i=0; i<n && i<l; i++){
			ans+=getLis(i, 0);
			ans%=mod;
		}
		ans *= l/n-k+1; 
		
	}
}
