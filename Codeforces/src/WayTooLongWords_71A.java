import java.io.BufferedReader;
import java.io.InputStreamReader;


public class WayTooLongWords_71A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		String str;
		for(int i=0; i<n; i++){
			str = br.readLine();
			if( str.length() <= 10)
				System.out.println(str);
			else{
				System.out.println( str.charAt(0)+""+(str.length()-2)+str.charAt(str.length()-1) );
			}
		}
	}
}
