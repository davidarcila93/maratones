import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ThePythagoreanTheorem_1582 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int x, y ,z;
		while((str = br.readLine())!=null){
			st = new StringTokenizer(str);
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			if( x*x+y*y==z*z || x*x+z*z==y*y || y*y+z*z==x*x ){
				if( gcd(x, y) == 1 )
					System.out.println("tripla pitagorica primitiva");
				else
					System.out.println("tripla pitagorica");
				
			}else{
				System.out.println("tripla");
			}
			
		}
	}
	
	public static int gcd(int a, int b){
		if(a%b==0)
			return b;
		return gcd(b, a%b);
	}

}
