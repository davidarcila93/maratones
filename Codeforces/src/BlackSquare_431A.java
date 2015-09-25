import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BlackSquare_431A {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int val[] = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<5; i++){
			val[i] = Integer.parseInt(st.nextToken());
		}
		String s = br.readLine();
		int ans = 0;
		for(int i=0; i<s.length(); i++){
			ans += val[s.charAt(i)-'0']; 
		}
		System.out.println(ans);
	}

}
