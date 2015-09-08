import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ILoveUsername_155A {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max, min;
		max = min = Integer.parseInt(st.nextToken());
		int aux, ans = 0;
		for(int i=1; i<n; i++){
			aux = Integer.parseInt(st.nextToken());
			if( aux< min){
				min =aux;
				ans++;
			}else if(aux>max){
				max = aux;
				ans++;
			}
			
		}
		System.out.println(ans);
	}

}
