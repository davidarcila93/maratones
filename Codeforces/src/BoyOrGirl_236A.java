import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BoyOrGirl_236A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		boolean[] c = new boolean[26];
		int count = 0;
		int id;
		for(int i=0; i<str.length(); i++){
			id = str.charAt(i)-'a';
			if(!c[id]){
				count++;
				c[id] = true;
			}
		}
		if(count%2==0)
			System.out.println("CHAT WITH HER!");
		else
			System.out.println("IGNORE HIM!");
	}
}
