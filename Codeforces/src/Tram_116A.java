import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Tram_116A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int ans = 0, cur = 0;
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			cur -= Integer.parseInt(st.nextToken());
			cur += Integer.parseInt(st.nextToken());
			ans = Math.max(ans, cur);
		}
		System.out.println(ans);
	}
}
