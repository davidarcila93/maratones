import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class buses {
	static TreeMap<BigInteger, BigInteger> map;
	static BigInteger mod=new BigInteger("1000000");
	static BigInteger N, K, L;
	static BigInteger Two=new BigInteger("2");
	
	public static BigInteger fastAns(BigInteger n){
		if(n.equals(BigInteger.ONE))
			return K;
		if(n.equals(BigInteger.ZERO))
			return BigInteger.ONE;
					
		if(map.containsKey(n))
			return map.get(n);
		BigInteger ans;
		BigInteger aux;
		if(n.mod(Two).equals(BigInteger.ZERO)){
			aux=fastAns(n.divide(Two));
			ans=aux.multiply(aux).mod(mod);
			aux=fastAns(n.divide(Two).subtract(BigInteger.ONE));
			aux=aux.multiply(aux).mod(mod).multiply(L).mod(mod);
			ans=ans.add(aux).mod(mod);
			map.put(n, ans);
			return ans;
		}
		else{
			aux=fastAns(n.divide(Two));
			aux=aux.multiply((aux.multiply(K)).add(L.multiply(Two.multiply(fastAns(n.divide(Two).subtract(BigInteger.ONE)))))).mod(mod);
			map.put(n, aux);
			return aux;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		DecimalFormat f=new DecimalFormat("000000", new DecimalFormatSymbols(Locale.US));
		while((str=br.readLine())!=null){
			map=new TreeMap<BigInteger, BigInteger>();
			st=new StringTokenizer(str);
			N=new BigInteger(st.nextToken());
			K=new BigInteger(st.nextToken());
			L=new BigInteger(st.nextToken());
			
			N=N.divide(new BigInteger("5"));
			K=K.mod(mod);
			L=L.mod(mod);
			System.out.println(f.format(fastAns(N).intValue()));;
		}
	}
}
