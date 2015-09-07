import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CalculatingFunction_486A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long ans = n/2;
		if( n%2 != 0)
			ans-=n;
		System.out.println(ans);
	}
}
