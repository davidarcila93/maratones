import java.io.BufferedReader;
import java.io.InputStreamReader;


public class PetyaAndStrings_112A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a, b;
		a = br.readLine().toLowerCase();
		b = br.readLine().toLowerCase();
		
		System.out.println(a.compareTo(b)==0 ? "0" : a.compareTo(b)/Math.abs( a.compareTo(b) ));
		
	}
}
