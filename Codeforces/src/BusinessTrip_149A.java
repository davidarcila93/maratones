import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BusinessTrip_149A {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[] v = new int[12];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<12; i++){
			v[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(v);
		int ans = 0;
		int size = 0;
		for(int i=11; i >= 0 && size < k ; i--){
			ans++;
			size+=v[i];
		}
		if(size < k)
			System.out.println("-1");
		else
			System.out.println(ans);
		
	}

}
