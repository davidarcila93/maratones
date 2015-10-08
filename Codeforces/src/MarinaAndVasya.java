import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MarinaAndVasya {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, t;
		String a, b;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		a = br.readLine();
		b = br.readLine();
		int eq =0;
		for(int i=0; i<n; i++){
			if(a.charAt(i) == b.charAt(i))
				eq++;
		}
		
		int aux = (n-eq+1)/2 ;
		
		int full = (n-eq)%2;
		int k = t-aux;
			
		
		if( t < aux )
			System.out.println("-1");
		else{
			int eqChanges = Math.min(k, eq);
			int difChanges = aux-eqChanges;
			
		}
	}
}
