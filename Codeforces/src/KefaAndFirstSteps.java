import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class KefaAndFirstSteps {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0; 
		int cur = 0;
		int last = 0;
		int aux;
		for(int i=0;i<n; i++){
			if( i == 0){
				cur = 1;
				ans = 1;
				last = Integer.parseInt(st.nextToken());
			}else{
				aux = Integer.parseInt(st.nextToken());
				if( aux >= last ){
					last = aux;
					cur++;
					ans = Math.max(ans, cur);
				}else{
					cur = 1;
					last = aux;
				}
			}
		}
		System.out.println(ans);
	}
}
