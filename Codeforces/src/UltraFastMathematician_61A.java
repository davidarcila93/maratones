import java.io.BufferedReader;
import java.io.InputStreamReader;


public class UltraFastMathematician_61A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a, b;
		a = br.readLine();
		b = br.readLine();
		for(int i=0; i<a.length(); i++){
			if( a.charAt(i) != b.charAt(i) )
				System.out.print("1");
			else
				System.out.print("0");
		}
	}
}
