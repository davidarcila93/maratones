import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class cake {
	static long[] x, y;
	static long[] xx, yy;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double ratio;
		int N;
		StringTokenizer st = new StringTokenizer(br.readLine());
		ratio = Double.parseDouble(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		x = new long[N];
		y = new long[N];
		xx = new long[N];
		yy = new long[N];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			x[i] = Long.parseLong(st.nextToken());
			y[i] = Long.parseLong(st.nextToken());
		}
		long initialArea = 0;
		for(int i=0; i<N; i++){
			initialArea += x[i]*y[(i+1)%N] - x[(i+1)%N]*y[i];
		}
		initialArea = Math.abs(initialArea);
		for(int i=0; i<N; i++){
			xx[i] = x[i]+x[(i+1)%N];
			yy[i] = y[i]+y[(i+1)%N];
		}
		long area = 0;
		for(int i=0; i<N; i++){
			area+= xx[i]*yy[(i+1)%N] - xx[(i+1)%N]*yy[i];
		}
		area = Math.abs(area);
		double ans = 2*Math.sqrt((initialArea-area/4.)/(initialArea*(1-ratio)) );
		System.out.println(ans);
	}
}
