import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class OrGame {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, k;
		long x;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Long.parseLong(st.nextToken());
		long aux = 0L;
		st = new StringTokenizer(br.readLine());
		long ans = 0L;
		
		long[] v = new long[n];
		long[] left = new long[n];
		long[] right = new long[n];
		for(int i=0; i<n; i++){
			v[i] = Long.parseLong(st.nextToken());
			aux ^= v[i];
		}
		
		for(int i=1; i<n; i++){
			left[i] = left[i-1] | v[i-1];
		}
		
		for(int i=n-2; i>=0; i--){
			right[i] = right[i+1] | v[i+1];
		}
		
		ans = aux;
		
		long tmp;
		for(int i=0; i<n; i++){
			tmp = v[i];
			for(int j=0; j<k; j++){
				tmp *= x;
				ans = Math.max(ans, left[i] | right[i] | tmp);
			}
		}
		
		System.out.println(ans);
		
	}
}
