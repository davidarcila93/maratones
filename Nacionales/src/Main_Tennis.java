import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_Tennis {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int a, b;
		while((str=br.readLine())!=null){
			st=new StringTokenizer(str);
			st.nextToken();
			a=Integer.parseInt(st.nextToken())-1;
			b=Integer.parseInt(st.nextToken())-1;
			
			System.out.println(Integer.toString(a^b, 2).length());
		}
	}
}
