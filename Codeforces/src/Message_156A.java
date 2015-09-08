import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Message_156A {

	static int dp[][][]; //dp[state][posa][posb] state 0 - starting 1 - adding 2 - not adding
	static String a, b;
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();
		dp = new int[3][a.length()+1][b.length()+1];
		for(int i=0; i<3; i++){
			for(int j=0; j<=a.length(); j++){
				Arrays.fill(dp[i][j], -1);
			}
		}
		System.out.println( getdp(0, 0, 0) );
	}
	
	public static int getdp(int state, int posa, int posb){
		if(dp[state][posa][posb]!=-1)
			return dp[state][posa][posb];
		if(posb == b.length())
			return 0;
		if(posa == a.length())
			return b.length()-posb;
		int ans = b.length()-posb;
		if( state == 2){
			if(a.charAt(posa) == b.charAt(posb))
				ans = Math.min(ans, getdp(2, posa+1, posb+1));
			else
				ans = Math.min(ans, 1 + getdp(2, posa+1, posb+1));
		}else if(state == 1){
			if(a.charAt(posa) == b.charAt(posb))
				ans = Math.min(ans, getdp(2, posa+1, posb+1));
			ans = Math.min(ans, 1 + getdp(1, posa, posb+1));
		}else{
			ans = Math.min(ans, getdp(0, posa+1, posb));
			ans = Math.min(ans, 1 + getdp(1, posa, posb+1));
			if(a.charAt(posa) == b.charAt(posb))
				ans = Math.min(ans, getdp(2, posa+1, posb+1));
		}
		return dp[state][posa][posb] = ans;
	}

}
