import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class GameWithSticks_451A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int n, m;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int a = Math.min(n, m);
		if(a%2==0)
			System.out.println("Malvika");
		else
			System.out.println("Akshat");
	}
}
