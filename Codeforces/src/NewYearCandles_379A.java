import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class NewYearCandles_379A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a, b; 
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int ans = 0;
		while(a>=b){
			ans += (a/b)*b;
			a = a/b + (a%b);
		}
		ans+=a;
		System.out.println(ans);
	}
}
