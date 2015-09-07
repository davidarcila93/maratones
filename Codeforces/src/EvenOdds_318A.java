import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class EvenOdds_318A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n, k;
		n = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());
		long odds = (n+1)/2;
		if(k<=odds)
			System.out.println( (k*2-1) );
		else
			System.out.println( (k-odds)*2 );
			
	}
}
