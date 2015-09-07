import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;


public class AmusingJoke_141A {
	public static void main(String[] args)throws  Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1, s2, s3;
		s1 = br.readLine();
		s2 = br.readLine();
		s3 = br.readLine();
		ArrayList<Character> v1 = new ArrayList<Character>();
		ArrayList<Character> v2 = new ArrayList<Character>();
		for(int i=0; i<s1.length(); i++){
			v1.add(s1.charAt(i));
		}
		for(int i=0; i<s2.length(); i++){
			v1.add(s2.charAt(i));
		}
		for(int i=0; i<s3.length(); i++){
			v2.add(s3.charAt(i));
		}
		Collections.sort(v1);
		Collections.sort(v2);
		if(v1.size() != v2.size())
			System.out.println("NO");
		else{
			for(int i=0; i<v1.size(); i++){
				if(v1.get(i) != v2.get(i)){
					System.out.println("NO");
					return;
				}
			}
			System.out.println("YES");
		}
	}
}
