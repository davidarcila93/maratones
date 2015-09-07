import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DominioPiling_50A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m, n;
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		System.out.println( (m*n)/2 );
	}
}
