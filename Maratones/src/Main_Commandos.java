import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_Commandos {
	static int[][] d=new int[100][100];
	static int n;
	static int INF=1<<29;
	public static void FloydWarshall(){
		for (int k = 0; k < d.length; k++) {
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d.length; j++) {
					d[i][j]=Math.min(d[i][j], d[i][k]+d[k][j]);
				}
			}
		}
	}
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int casos=Integer.parseInt(br.readLine());
		int r, a, b, s, t;
		for (int i = 1; i <= casos; i++) {
			n=Integer.parseInt(br.readLine());
			d=new int[n][n];
			for (int j = 0; j < n; j++) {
				Arrays.fill(d[j], INF);
			}
			for (int j = 0; j < n; j++) {
				d[j][j]=0;
			}
			r=Integer.parseInt(br.readLine());
			for (int j = 0; j < r; j++) {
				st=new StringTokenizer(br.readLine());
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				d[a][b]=1;
				d[b][a]=1;
			}
			st=new StringTokenizer(br.readLine());
			s=Integer.parseInt(st.nextToken());
			t=Integer.parseInt(st.nextToken());
			FloydWarshall();
			int max=0;
			for (int j = 0; j < d.length; j++) {
				max=Math.max(max, d[s][j]+d[j][t]);
			}
			System.out.println("Case "+i+": "+max);
		}
	}
}
