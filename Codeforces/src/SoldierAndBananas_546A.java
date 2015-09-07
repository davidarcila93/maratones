import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SoldierAndBananas_546A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k, n, w;
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		int dolars = k*((w*(w+1))/2);
		System.out.println(Math.max(0, dolars-n));
	}
}
