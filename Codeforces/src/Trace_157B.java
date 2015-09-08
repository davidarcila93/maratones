import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Trace_157B {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r[] = new int[n];
		for(int i=0; i<n; i++){
			r[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(r);
		int ans = 0;
		for(int i = n-1; i>=0; i--){
			if( (n-1-i)%2==0 )
				ans += r[i]*r[i];
			else
				ans -= r[i]*r[i];
		}
		System.out.println(Math.PI*ans);
	}

}
