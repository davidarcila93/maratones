import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class JokingWithFermatsLastTheorem_12665 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x, y;
		String str;
		StringTokenizer st;
		int aux, ans;
		int T=0;
		while((str = br.readLine())!=null){
			T++;
			st = new StringTokenizer(str);
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			ans = 0;
			for(int i=x; i<=y && i<1000 ; i++){
				for(int j=x; j<=y && j<1000 ; j++){
					aux = i*i*i + j*j*j;
					if( aux%10 == 3 && aux/10>=x && aux/10<=y )
						ans++;
				}
			}
			System.out.println("Case "+T+": "+ans);
		}
	}

}
