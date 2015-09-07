import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Taxi_158B {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] v = new int[5];
		int aux;
		for(int i=0; i<n; i++){
			aux = Integer.parseInt(st.nextToken());
			v[aux]++;
		}
		int ans = 0;
		ans = v[4];
		ans += v[2]/2;
		v[2] %= 2;
		ans += v[3];
		v[1] -=v[3];
		ans+=v[2];
		v[1]-=2*v[2];
		if(v[1]>0)
			ans+= (v[1]+3)/4;
		System.out.println(ans);
	}
}
