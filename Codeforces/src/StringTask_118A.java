import java.io.BufferedReader;
import java.io.InputStreamReader;


public class StringTask_118A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.toLowerCase();
		str = str.replaceAll("[aeiouy]", "");
		for(int i=0; i<str.length(); i++){
			System.out.print("."+str.charAt(i));
		}
	}
}
