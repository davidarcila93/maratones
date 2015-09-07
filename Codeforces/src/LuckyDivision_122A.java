import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LuckyDivision_122A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean flag = false;
		for(int i=1; i<=n; i++){
			if( isLucky(i) && n%i==0)
				flag = true;
		}
		if(flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	public static boolean isLucky(int n){
		String s = ""+n;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)!='4' && s.charAt(i)!='7')
				return false;
		}
		return true;
	}
}
