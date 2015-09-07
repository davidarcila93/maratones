import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class zero {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int a, b, c;
		while((str=br.readLine())!=null){
			st=new StringTokenizer(str);
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			if(a!=b && a!=c)
				System.out.println("A");
			else if(b!=c && b!=a)
				System.out.println("B");
			else if(c!=a && c!=b)
				System.out.println("C");
			else
				System.out.println("*");
			
		}
	}
}
