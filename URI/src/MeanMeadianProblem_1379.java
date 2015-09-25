import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MeanMeadianProblem_1379 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		StringTokenizer st;
		String str;
		int a, b, aux;
		while((str = br.readLine())!=null){
			st = new StringTokenizer(str);
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if( a == 0 && b == 0)
				break;
			if(b<a){
				aux = b;
				b = a;
				a = aux;
			}
			
			System.out.println( (a+a-b) );
			
		}
	}

}
