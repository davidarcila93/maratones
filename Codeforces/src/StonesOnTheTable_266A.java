import java.io.BufferedReader;
import java.io.InputStreamReader;


public class StonesOnTheTable_266A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = br.readLine();
		int ans =0; 
		for(int i=1; i<str.length(); i++){
			if( str.charAt(i) == str.charAt(i-1) )
				ans++;
		}
		System.out.println(ans);
	}
}
