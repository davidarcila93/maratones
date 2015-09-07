import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class RelationalOperators_11172 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int a, b;
		for(int i=0; i<n; i++){
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			if(a<b)
				System.out.println("<");
			else if(a>b)
				System.out.println(">");
			else
				System.out.println("=");
		}
	}

}
