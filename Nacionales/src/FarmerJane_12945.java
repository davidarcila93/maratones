import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;


public class FarmerJane_12945 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		while( (str = br.readLine() ) !=null){
			int n = Integer.parseInt(str);
			int acux = 0, acuy = 0, tot = 0;
			int x[], y[], w[];
			x = new int[n];
			y = new int[n];
			w = new int[n];
			for(int i=0; i<n; i++){
				st = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
				w[i] = Integer.parseInt(st.nextToken());
				tot +=w[i];
				acux +=x[i]*w[i];
				acuy +=y[i]*w[i];
			}
			double xx, yy;
			xx = acux/(double)tot;
			yy = acuy/(double)tot;
			double ans = 0.;
			for(int i=0; i<n; i++){
				ans += w[i]*( (x[i]-xx)*(x[i]-xx) + (y[i]-yy)*(y[i]-yy) );
			}
			System.out.printf(Locale.US, "%.3f\n", ans);	
		}
	}
}
