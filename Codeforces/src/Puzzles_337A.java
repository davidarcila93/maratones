import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Puzzles_337A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int v[] = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++){
			v[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(v);
		int min = 10000000;
		for(int i =0; i<m-n+1; i++){
			min = Math.min(min, v[i+n-1] - v[i]);
		}
		System.out.println(min);
	}
}
