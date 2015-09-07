import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FoxAndSnake_510A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if( i%2==0 )
					System.out.print("#");
				else if( i%4==1 && j==m-1)
					System.out.print("#");
				else if( i%4==3 && j==0)
					System.out.print("#");
				else 
					System.out.print(".");
			}
			System.out.println();
		}
	}
}
