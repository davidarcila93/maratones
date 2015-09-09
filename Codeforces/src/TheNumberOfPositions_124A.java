import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TheNumberOfPositions_124A {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, a, b;
		n = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		System.out.println( Math.min(n-a, b+1) );
		
	}

}
