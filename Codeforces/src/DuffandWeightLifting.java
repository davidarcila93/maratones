import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DuffandWeightLifting {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] v = new int[20000001];
		int aux;
		for(int i=0; i<n; i++){
			aux = Integer.parseInt(st.nextToken());
			v[aux]++;
			while(v[aux]>=2){
				v[aux]-=2;
				aux++;
				v[aux]++;
			}
		}
		int ans=0;
		for(int i=0; i<v.length; i++){
			if(v[i]==1)
				ans++;
		}
		System.out.println(ans);
	}
	
}
