import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CapsLock_131A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.toUpperCase().equals(str)){
			System.out.println(str.toLowerCase());
		}else if( str.toUpperCase().equals( (""+str.charAt(0)).toUpperCase()+str.substring(1, str.length()) ) ){
			System.out.println( (""+str.charAt(0)).toUpperCase()+str.substring(1, str.length()).toLowerCase() );
		}else{
			System.out.println(str);
		}
	}
}
