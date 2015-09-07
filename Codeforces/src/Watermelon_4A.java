import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Watermelon_4A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n%2 == 0 && n>2)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
