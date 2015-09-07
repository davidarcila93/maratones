import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Twins_160A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] v = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = 0;
		for(int i=0; i<n; i++){
			v[i] = Integer.parseInt(st.nextToken());
			total+=v[i];
		}
		Arrays.sort(v);
		int cur = 0;
		int count = 0;
		for(int i=v.length-1; i>=0; i--){
			count++;
			cur+=v[i];
			if(cur > total/2)
				break;
		}
		System.out.println(count);
	}
}
