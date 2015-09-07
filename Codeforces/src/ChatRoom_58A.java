import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ChatRoom_58A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String h = "hello";
		String str = br.readLine();
		int id = 0;
		for(int i=0; i<str.length() && id<h.length(); i++){
			if(str.charAt(i) == h.charAt(id))
				id++;
		}
		if( id == h.length())
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
