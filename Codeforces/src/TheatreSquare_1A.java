import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TheatreSquare_1A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n, m, a;
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		a = Long.parseLong(st.nextToken());
		long ans = ((n+a-1)/a)*((m+a-1)/a);
		System.out.println(ans);
	}
}
