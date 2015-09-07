import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Translation_41A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a, b;
		a = br.readLine();
		b = br.readLine();
				
		if(a.length()!=b.length())
			System.out.println("NO");
		else{
			for(int i=0; i<a.length(); i++){
				if( a.charAt(i) != b.charAt(b.length()-1-i) ){
					System.out.println("NO");
					return;
				}
			}
			System.out.println("YES");
		}
				
	}
}
