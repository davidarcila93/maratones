import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class WeaknessAndPoorness {
	
	static int v[];
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		v = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine() );
		for(int i=0; i<n; i++){
			v[i] = Integer.parseInt(st.nextToken() );
		}
		
		
		double min, max, m1, m2;
		min = -10010;
		max = 10010;
		
		while( max - min > 1e-11 ){
			m1 = min+(max-min)/3.;
			m2 = min+2*(max-min)/3.;
			
			if( calc(m1) < calc(m2)){
				max = m2;
			}else{
				min = m1;
			}
		}
		System.out.println(calc( (max+min)/2 ));
		
	}
	
	public static double calc( double x ){
		double ans = 0;
		double max, min;
		max = v[0]-x;
		min = v[0]-x;
		ans = Math.max(Math.abs(max), Math.abs(min));
		for(int i=1; i<v.length; i++){
			max = Math.max( max+v[i]-x, v[i]-x);
			ans = Math.max(ans, Math.abs(max));
			
			min = Math.min( min+v[i]-x, v[i]-x);
			ans = Math.max(ans, Math.abs(min));
		}
		
		return ans;
	}
}
