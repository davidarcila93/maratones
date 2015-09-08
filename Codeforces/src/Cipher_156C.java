import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Cipher_156C {

	static long mod = 1000000000L+7;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String s;
		long[][] dp;
		while(T-- > 0){
			s = br.readLine();
			dp = new long[ s.length() ][ 60 ];
			for(int i=0; i<60; i++){
				dp[ s.length()-1 ][i] = 1;
			}
			for(int pos = s.length()-2; pos>=0; pos--){
				
			}
		}
	}

}
