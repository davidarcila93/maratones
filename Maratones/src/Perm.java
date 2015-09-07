import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.StringTokenizer;


public class Perm {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		br.readLine();
		int pi[];
		String s[];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st=new StringTokenizer(br.readLine());
			pi=new int[st.countTokens()];
			s=new String[st.countTokens()];
			for (int j = 0; j < pi.length; j++) {
				pi[j]=Integer.parseInt(st.nextToken())-1;
			}
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < s.length; j++) {
				s[pi[j]]=st.nextToken();
			}
			
			for (int j = 0; j < s.length; j++) {
				System.out.println(s[j]);
			}
			if(i!=n-1)
				System.out.println();
			br.readLine();
		}
		
	}

}
