import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class HelpfulMaths_339A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		ArrayList<Integer> v = new ArrayList<Integer>();
		for(int i=0; i<str.length(); i+=2){
			v.add(str.charAt(i)-'0');
		}
		Collections.sort(v);
		for(int i=0; i<v.size(); i++){
			if(i!=0)
				System.out.print("+");
			System.out.print(v.get(i));
		}
		System.out.println();
	}
}
