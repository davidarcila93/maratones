import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Buses_1474 {
	
	static long n, k, l;
	static TreeMap<Long, Long> map;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		String str;
		while((str = br.readLine())!=null){
			st = new StringTokenizer(str);
			n = Long.parseLong(st.nextToken())/5;
			k = Long.parseLong(st.nextToken())%1000000;
			l = Long.parseLong(st.nextToken())%1000000;
			map = new TreeMap<Long, Long>();
			System.out.printf("%06d\n", f(n));
		}
	}
	
	public static long f(long a){
		if(map.containsKey(a))
			return map.get(a);
		if(a==0)
			return 1;
		if(a==1)
			return k;
		long ans;
		long aux, aux1;
		aux = f(a/2);
		aux1 = f(a/2-1);
		if( a%2==1 ){
			ans = ((k*aux)%1000000*aux)%1000000;
			ans += (2*(l*(aux*aux1)%1000000)%1000000)%1000000;
			ans%=1000000;
		}else{
			ans = (aux*aux)%1000000;
			ans+= (l*aux1)%1000000*aux1;
			ans%=1000000;
		}
		map.put(a, ans);
		return ans;
	}
	

}
