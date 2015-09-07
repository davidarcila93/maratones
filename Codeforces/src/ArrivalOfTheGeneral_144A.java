import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ArrivalOfTheGeneral_144A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int v[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int idmin = -1, idmax = -1, valmin = 1000000, valmax = -1;
		for(int i=0; i<n; i++){
			v[i] = Integer.parseInt(st.nextToken());
			if( v[i] > valmax){
				valmax = v[i];
				idmax = i;
			}
			if( v[i] <= valmin ){
				valmin = v[i];
				idmin = i;
			}
		}
		
		int ans = idmax + n-1-idmin;
		if(idmax > idmin)
			ans--;
		System.out.println(ans);
	}
}
