import java.io.BufferedReader;
import java.io.InputStreamReader;


public class InsomniaCure_348A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k, l, m, n, d;
		k = Integer.parseInt(br.readLine());
		l = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		d = Integer.parseInt(br.readLine());
		boolean used[] = new boolean[d];
		for(int i=k-1; i<d; i+=k){
			used[i] = true;
		}
		for(int i=l-1; i<d; i+=l){
			used[i] = true;
		}
		for(int i=m-1; i<d; i+=m){
			used[i] = true;
		}
		for(int i=n-1; i<d; i+=n){
			used[i] = true;
		}
		int ans =0; 
		for(int i=0; i<d; i++){
			if(used[i])
				ans++;
		}
		System.out.println(ans);
	}
}
