import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Rewards_448A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cups = Integer.parseInt(st.nextToken()) +Integer.parseInt(st.nextToken()) +Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int medals = Integer.parseInt(st.nextToken()) +Integer.parseInt(st.nextToken()) +Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		if( (cups+4)/5 + (medals+9)/10 <=n)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
