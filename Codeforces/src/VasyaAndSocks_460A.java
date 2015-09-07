import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class VasyaAndSocks_460A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m;
		n =Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		int day = 0;
		while(day < n){
			day++;
			if(day%m == 0)
				n++;
		}
		System.out.println(day);
	}
}
