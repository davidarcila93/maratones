import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class EpicGame_119A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a, b, n;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = 0; 
		while(n>0){
			if(k == 0)
				n = n-gcd(a, n);
			else
				n = n-gcd(b, n);
			k = 1-k;
		}
		System.out.println( 1-k );	
	}
	
	public static int gcd(int a, int b){
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
}
