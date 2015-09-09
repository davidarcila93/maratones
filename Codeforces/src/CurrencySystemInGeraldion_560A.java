import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CurrencySystemInGeraldion_560A {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean one = false;
		while(st.hasMoreTokens()){
			if( st.nextToken().equals("1"))
				one = true;
		}
		if(one)
			System.out.println("-1");
		else
			System.out.println("1");
	}

}
