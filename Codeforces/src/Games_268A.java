import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Games_268A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] h = new int[n];
		int[] g = new int[n];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			h[i] = Integer.parseInt(st.nextToken());
			g[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(i==j)
					continue;
				if( h[i] == g[j] )
					count++;
			}
		}
		System.out.println(count);
	}
}
