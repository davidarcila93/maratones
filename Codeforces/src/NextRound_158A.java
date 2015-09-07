import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class NextRound_158A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, k;
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int v[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			v[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int val = v[k-1];
		for(int i=0; i<n; i++){
			if( v[i]!=0 && v[i]>=val )
				ans++;
		}
		System.out.println(ans);
	}
}
