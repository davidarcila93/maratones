import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BeautifulYear_271A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		n++;
		while(!difDigits(n)){
			n++;
		}
		System.out.println(n);
	}
	
	public static boolean difDigits(int n){
		String s = ""+n;
		for(int i=0; i<s.length(); i++){
			for(int j = i+1; j<s.length(); j++){
				if(s.charAt(i)==s.charAt(j))
					return false;
			}
		}
		return true;
	}
}
