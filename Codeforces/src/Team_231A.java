import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Team_231A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int ans = 0, aux;
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			aux = 0;
			aux += Integer.parseInt(st.nextToken());
			aux += Integer.parseInt(st.nextToken());
			aux += Integer.parseInt(st.nextToken());
			if(aux>=2)
				ans++;
		}
		System.out.println(ans);
	}
}
