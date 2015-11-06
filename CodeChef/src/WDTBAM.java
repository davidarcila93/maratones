import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class WDTBAM {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String a, b;
		int T = Integer.parseInt(br.readLine());
		int n;
		int eq;
		int ans;
		int aux=0;
		while( T-->0 ){
			n = Integer.parseInt(br.readLine());
			a = br.readLine();
			b = br.readLine();
			
			eq=0;
			for(int i=0; i<a.length(); i++){
				if( a.charAt(i) == b.charAt(i) )
					eq++;
			}
			st = new StringTokenizer(br.readLine());
			ans = 0;
			for(int i=0; i<=eq; i++){
				aux = Integer.parseInt(st.nextToken());
				ans = Math.max(ans, aux);
			}
			if(eq == n)
				System.out.println(aux);
			else
				System.out.println(ans);
		}
	}
}
