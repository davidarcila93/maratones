import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Football_96A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int ans = 0;
		int cur = 0;
		for(int i=0; i<str.length(); i++){
			if( i==0 || str.charAt(i)==str.charAt(i-1)){
				cur++;
			}else{
				cur = 1;
			}
			
			ans = Math.max(ans, cur);
		}
		if(ans>=7)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
