import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class YoungPhysicist_69A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int x=0, y=0, z=0;
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			x+=Integer.parseInt(st.nextToken());
			y+=Integer.parseInt(st.nextToken());
			z+=Integer.parseInt(st.nextToken());
		}
		if(x == 0 && y == 0 && z == 0)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
