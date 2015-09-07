import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Rational {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BigInteger n1, n2, d1, d2, gcd,n,d;
		char c;
		StringBuilder sb=new StringBuilder();
		int k=Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st=new StringTokenizer(br.readLine());
			n1=new BigInteger(st.nextToken());
			st.nextToken();
			d1=new BigInteger(st.nextToken());
			c=st.nextToken().charAt(0);
			n2=new BigInteger(st.nextToken());
			st.nextToken();
			d2=new BigInteger(st.nextToken());
			
			switch (c) {
			case '+':
				n=n1.multiply(d2).add(n2.multiply(d1));
				d=d1.multiply(d2);
				break;
				
			case '-':
				n=n1.multiply(d2).subtract(n2.multiply(d1));
				d=d1.multiply(d2);
				break;
				
			case '*':
				n=n1.multiply(n2);
				d=d1.multiply(d2);
				break;
				
			default :
				n=n1.multiply(d2);
				d=d1.multiply(n2);
				break;
			}
			
//			System.out.print(n+"/"+d+" = ");
			sb.append(n+"/"+d+" = ");
			gcd=n.gcd(d);
			n=n.divide(gcd);
			d=d.divide(gcd);
			
//			System.out.println(n+"/"+d);
			sb.append(n+"/"+d+"\n");
		}
		System.out.print(sb);
	}

}
