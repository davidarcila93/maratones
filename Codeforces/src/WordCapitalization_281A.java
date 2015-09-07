import java.io.BufferedReader;
import java.io.InputStreamReader;


public class WordCapitalization_281A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println( (""+str.charAt(0)).toUpperCase() + str.substring(1) );
	}
}
