import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class GameOutcome_157A {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] m = new int[n][n];
		int[] row, col;
		row = new int[n];
		col = new int[n];
		StringTokenizer st;
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				m[i][j] = Integer.parseInt(st.nextToken());
				row[i]+=m[i][j];
				col[j]+=m[i][j];
			}
		}
		int ans = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(col[j]>row[i])
					ans++;
			}
		}
		System.out.println(ans);
	}
}
