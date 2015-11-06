import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Lottery_589I {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k, n;
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int count[] = new int[n];
		int aux;
		for(int i=0; i<k; i++){
			aux = Integer.parseInt(st.nextToken());
			aux--;
			count[aux]++;
		}
		int ans = 0;
		for(int i=0; i<n; i++){
			if( count[i] > k/n)
				ans += count[i]-k/n;
		}
		System.out.println(ans);
	}
}
