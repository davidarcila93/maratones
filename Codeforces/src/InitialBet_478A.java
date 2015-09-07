import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class InitialBet_478A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		for(int i=0; i<5; i++){
			ans+=Integer.parseInt(st.nextToken());
		}
		if( ans!=0 && ans%5==0)
			System.out.println(ans/5);
		else
			System.out.println("-1");
	}
}
