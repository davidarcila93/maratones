import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class AdvancingLetters_1607 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String a, b;
		StringTokenizer st;
		int aa, bb;
		int ans;
		while(T-->0){
			st = new StringTokenizer(br.readLine());
			a = st.nextToken();
			b = st.nextToken();
			ans =0;
			for(int i=0; i<a.length(); i++){
				aa = a.charAt(i);
				bb = b.charAt(i);
				
				if( bb >= aa)
					ans+=bb-aa;
				else
					ans+= 'z'-aa+bb-'a'+1;
			}
			System.out.println(ans);
		}
	}

}
