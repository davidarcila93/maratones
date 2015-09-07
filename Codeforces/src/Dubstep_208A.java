import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Dubstep_208A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.replaceAll("^(WUB)*", "");
		s = s.replaceAll("(WUB)*$", "");
		s = s.replaceAll("(WUB)+", " ");
		System.out.println(s);
	}
}
