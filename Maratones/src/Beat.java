import java.io.*;
import java.util.*;
import java.lang.Integer.*;


public class Beat {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int a,b;
		int p,q;
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			if(a<b || (a+b)%2!=0)
				System.out.println("impossible");
			else
				System.out.println(((a+b)/2)+" "+((a-b)/2));
		}	
		
		
	}

}
