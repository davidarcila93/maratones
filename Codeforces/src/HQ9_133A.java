import java.io.BufferedReader;
import java.io.InputStreamReader;


public class HQ9_133A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		boolean flag = false;
		for(int i=0; i<str.length(); i++){
			if( str.charAt(i) == 'H' || str.charAt(i) == 'Q' || str.charAt(i) == '9')
				flag = true;
		}
		if(flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
