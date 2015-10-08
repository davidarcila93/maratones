import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;


public class IntersectingCircles_453 {

	static double EPS = 1e-9;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		double x1, y1, r1, x2, y2, r2;
		double h;
		double angle;
		double min, max, mid;
		double xx1, xx2, yy1, yy2;
		while((str = br.readLine())!=null){
			st = new StringTokenizer(str);
			x1 = Double.parseDouble(st.nextToken());
			y1 = Double.parseDouble(st.nextToken());
			r1 = Double.parseDouble(st.nextToken());
			st = new StringTokenizer(br.readLine());
			x2 = Double.parseDouble(st.nextToken());
			y2 = Double.parseDouble(st.nextToken());
			r2 = Double.parseDouble(st.nextToken());
			
			if( Math.abs(x1-x2)<EPS && Math.abs(y1-y2)<EPS && Math.abs(r1-r2)<EPS )
				System.out.println("THE CIRCLES ARE THE SAME");
			else{
				h = Math.hypot(x1-x2, y1-y2);
				if( h-EPS < r1+r2 && r1-EPS < h+r2 && r2-EPS < r1+h ){
					
					angle = Math.atan2(y2-y1, x2-x1);
					if( Math.abs( Math.hypot( x1 + r1*Math.cos(angle) -x2 , y1 + r1*Math.sin(angle)-y2) - r2) < EPS ){
						System.out.printf(Locale.US, "(%.3f,%.3f)\n", x1 + r1*Math.cos(angle) , y1 + r1*Math.sin(angle) );
					} else if( Math.abs( Math.hypot( x1 + r1*Math.cos(angle + Math.PI) -x2 , y1 + r1*Math.sin(angle + Math.PI)-y2) - r2) < EPS ){
						System.out.printf(Locale.US, "(%.3f,%.3f)\n", x1 + r1*Math.cos(angle + Math.PI) , y1 + r1*Math.sin(angle + Math.PI) );
					} else{
						
						min = angle;
						max = angle + Math.PI;
						mid = (max+min)/2.;
						while( (max-min)*r1 > 1e-4){
							mid = (max+min)/2.;
							double dist = Math.hypot(x1 + r1*Math.cos(mid)-x2 , y1 + r1*Math.sin(mid)-y2);
							if( dist > r2 )
								max = mid;
							else
								min = mid;
						}
						xx1 = x1 + r1*Math.cos(mid);
						yy1 = y1 + r1*Math.sin(mid);
						
						max = angle;
						min = angle - Math.PI;
						mid = (max+min)/2.;
						while( (max-min)*r1 > 1e-4){
							mid = (max+min)/2.;
							double dist = Math.hypot(x1 + r1*Math.cos(mid)-x2 , y1 + r1*Math.sin(mid)-y2);
							if( dist < r2 )
								max = mid;
							else
								min = mid;
						}
						xx2 = x1 + r1*Math.cos(mid);
						yy2 = y1 + r1*Math.sin(mid);
						
						if( Math.abs(xx1-xx2) < EPS){
							if( yy1>yy2 ){
								double aux = yy1;
								yy1 = yy2;
								yy2 = aux;
								aux = xx1;
								xx1 = xx2;
								xx2 = aux;
										
							}
						}
						else{
							if( xx1>xx2 ){
								double aux = yy1;
								yy1 = yy2;
								yy2 = aux;
								aux = xx1;
								xx1 = xx2;
								xx2 = aux;
							}
						}
						
						System.out.printf(Locale.US, "(%.3f,%.3f)(%.3f,%.3f)\n", xx1, yy1, xx2, yy2 );
					}
					
				}else
					System.out.println("NO INTERSECTION");
					
			}
				
			
		}
	}

}
