import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;
import java.util.StringTokenizer;


public class Main_FloydWarshall {
	static int[][] d;
	static int INF=1<<29;
	
	public static void FloydWarshall(){
		for (int k = 0; k < 100; k++) {
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					d[i][j]=Math.min(d[i][j], d[i][k]+d[k][j]);
				}
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int a, b, caso=0;
		while(!(str=br.readLine()).contentEquals("0 0")){
			caso++;
			d=new int[100][100];
			for (int i = 0; i < 100; i++) {
				Arrays.fill(d[i], INF);
			}
			st=new StringTokenizer(str);
			while((a=Integer.parseInt(st.nextToken()))!=0){
				b=Integer.parseInt(st.nextToken());
				a--;
				b--;
				d[a][b]=1;
			}
			
			FloydWarshall();
			
			
			
			int sum=0;
			int k=0;
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if(i!=j && d[i][j]!=INF){
						sum+=d[i][j];
						k++;
					}
				}
				
			}
			DecimalFormat f=new DecimalFormat("#.000", new DecimalFormatSymbols(Locale.US));
			double ans=sum/(double)k;
			System.out.println("Case "+caso+": average length between pages = "+f.format(ans)+" clicks");
//			System.out.printf("Case %d: average length between pages = %f clicks\n", caso, ans);
		}
	}
}
