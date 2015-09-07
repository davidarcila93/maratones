import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Tiles {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n,a,b;
		String str;
		int ans;
		int mcm;
		while((str=br.readLine())!=null){
			st=new StringTokenizer(str);
			n=Integer.parseInt(st.nextToken());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			if(n==0 && a==0 && b==0)
				break;
			mcm=BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).divide(BigInteger.valueOf(a).gcd(BigInteger.valueOf(b))).intValue();
			
			ans=n/a+n/b-n/mcm;
			System.out.println(ans);
		}
		
	}

}
