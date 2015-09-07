import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CocircularPoints {
	
	static final double EPS = 1e-7;
	static int[] x, y;
	static double[][] dist;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		StringBuilder sb = new StringBuilder();
		n=Integer.parseInt(br.readLine());
		while(n!=0){
			x=new int[n];
			y=new int[n];
			for(int i=0; i<n; i++){
				st = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			dist= new double[n][n];
	        for(int i=0; i<n; i++){
	            for(int j=0; j<n; j++){
	                dist[i][j]=Math.hypot(x[i]-x[j], y[i]-y[j]);
	            }
	        }
			
			int ans=0;
			if(n>=1)
				ans=1;
			if(n>=2)
				ans=2;
			int tmp;
			for(int a = 0; a<n; a++)
				for(int b=a+1; b<n; b++){
					for(int c=b+1; c<n; c++){
						if(cross(a, b, c)==0)
							continue;
						tmp=3; 
						for(int k=c+1; k<n; k++){
							if(cocircular(a, b, c, k) || cocircular(a, b, k, c) || cocircular(a, k, b, c)){
								tmp++;
								System.out.println(x[a]+" "+y[a]+" "+x[b]+" "+y[b]+" "+x[k]+" "+y[k]+" "+x[c]+" "+y[c]);
//								System.out.println("OK "+a+" "+b+" "+c+" "+k);
							}
						}
						ans = Math.max(ans, tmp);
					}
				}
			sb.append(ans).append("\n");
//			System.out.println(ans);
			n=Integer.parseInt(br.readLine());
		}
		System.out.print(sb);
	}
	
	private static int cross(int a, int b, int c){
		int x1 = x[a]-x[b];
		int y1 = y[a]-y[b];
		int x2 = x[c]-x[b];
		int y2 = y[c]-y[b];
		return x1*y2-y1*x2;
	}

	private static boolean cocircular(int a, int b, int c, int k) {
//		double d1 = Math.hypot(x[a]-x[c], y[a]-y[c]);
//		double d2 = Math.hypot(x[b]-x[k], y[b]-y[k]);
//		double s1 = Math.hypot(x[a]-x[b], y[a]-y[b]);
//		double s2 = Math.hypot(x[b]-x[c], y[b]-y[c]);
//		double s3 = Math.hypot(x[c]-x[k], y[c]-y[k]);
//		double s4 = Math.hypot(x[k]-x[a], y[k]-y[a]);
		if(Math.abs(dist[a][c]*dist[b][k]-dist[a][b]*dist[c][k]-dist[b][c]*dist[a][k])<EPS)
			return true;
		return false;
	}
}
