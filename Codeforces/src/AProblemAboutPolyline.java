import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class AProblemAboutPolyline {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a, b;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		if(b>a)
			System.out.println("-1");
		else{
			int aux = (a-b)/(2*b);
//			System.out.println(aux);
			int k = 2*aux+1;
//			System.out.println(k);
			double x = (a-b)%(2*b)/(double)(k+1);
//			System.out.println(x);
			System.out.println((b+x));
		}
		
	}
}
