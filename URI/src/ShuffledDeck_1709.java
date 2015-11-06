import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ShuffledDeck_1709 {
	
	static int n;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int aux;
		while((str = br.readLine())!=null){
			n = Integer.parseInt(str);
			aux = next(0);
			int ans = 1;
			while(aux!=0){
				ans++;
				aux = next(aux);
			}
			System.out.println(ans);	
		}
	}
	
	public static int next(int k){
		if(k<n/2)
			return 2*k+1;
		k-=n/2;
		return 2*k;
	}
}
