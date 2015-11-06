import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.util.StringTokenizer;


public class growling {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n;
		long a[] = new long[12], b[] = new long[12], c[] = new long[12];
		StringTokenizer st;
		while(T-->0){
			n = Integer.parseInt(br.readLine());
			for(int i=1; i<=n; i++){
				st = new StringTokenizer(br.readLine());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=1; i<=n; i++) {
				boolean ok = true;
				for(int j=1; j<=n; j++) {
					if( (b[i]*b[i] + 4*a[i]*c[i])*4*a[j] < (b[j]*b[j] + 4*a[j]*c[j])*4*a[i]) {
						ok =  false;
						break;
					}
				} 
				if(ok) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}
