import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main_UncleJack {
	static BigInteger Two=new BigInteger("2");
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		BigInteger a,b;
		while(!(str=br.readLine().trim()).contentEquals("0 0")){
			st=new StringTokenizer(str);
			a=new BigInteger(st.nextToken());
			b=new BigInteger(st.nextToken());
			System.out.println(fastpow(a,b));
		}
	}

	private static BigInteger fastpow(BigInteger a, BigInteger b) {
		if(b.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		if(b.equals(BigInteger.ONE))
			return a;
		BigInteger aux;
		aux=fastpow(a, b.divide(Two));
		if(b.mod(Two).equals(BigInteger.ZERO))
			return aux.multiply(aux);
		return aux.multiply(aux.multiply(a));
		
	}
}
