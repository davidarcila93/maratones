import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ChefAndPolygons_CHPLGNS {

	public static class Polygon implements Comparable<Polygon>{

		int id;
		ArrayList<Long> x, y;
		BigInteger area;
		
		public Polygon(int id, ArrayList<Long> x, ArrayList<Long> y) {
			this.id=id;
			this.x=x; 
			this.y=y;
			this.area= BigInteger.ZERO;
			for(int i=0; i<x.size()-1; i++){
				this.area = this.area.add( new BigInteger( ""+x.get(i) ).multiply( new BigInteger( ""+y.get(i+1) ) ) ).subtract( new BigInteger( ""+x.get(i+1) ).multiply( new BigInteger( ""+y.get(i) ) ) );
//				this.area = x.get(i)*y.get(i+1)-x.get(i+1)*y.get(i);
			}
			if(this.area.compareTo(BigInteger.ZERO)==-1)
				this.area = this.area.multiply(new BigInteger("-1"));
		}
		
		@Override
		public int compareTo(Polygon o) {
			return this.area.compareTo(o.area);
		}
		
	}
	
//	public static double dot(int x1, int y1, int x2, int y2){
//		return x1*x2+y1*y2;
//	}
//	
//	public static double cross(int x1, int y1, int x2, int y2){
//		return x1*y2-x2*y1;
//	}
//	
//	public static boolean ccw(int x1, int y1, int x2, int y2, int x3, int y3){
//		return (cross(x1-x2, y1-y2, x3-x2, y3-y2)>0);
//	}
//	
//	public static double angle(int x1, int y1, int x2, int y2, int x3, int y3){
//		return Math.acos(dot(x1-x2, y1-y2, x3-x2, y3-y2)/(Math.hypot(x1-x2, y1-y2)*Math.hypot(x3-x2, y3-y2)));
//	}
	
	public static void main(String[] args) throws Exception{
		int T, n, m;
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		StringTokenizer st;
		T = sc.nextInt();
		ArrayList<Polygon> polygons;
		ArrayList<Long> x, y;
		int[] ans;
		for(int t=0; t<T; t++){
			n = sc.nextInt();
			polygons = new ArrayList<Polygon>();
			for(int i=0; i<n; i++){
				x = new ArrayList<Long>();
				y = new ArrayList<Long>();
				m = sc.nextInt();
//				st = new StringTokenizer(br.readLine().trim());
				for(int j=0; j<m; j++){
					x.add(sc.nextLong());
					y.add(sc.nextLong());
				}
				x.add(x.get(0));
				y.add(y.get(0));
				polygons.add(new Polygon(i, x, y));
			}
			Collections.sort(polygons);
			ans= new int[n];
			for(int i=0; i<n; i++){
//				System.out.println(polygons.get(i).area);
				ans[polygons.get(i).id] = i;
			}
			for(int i=0; i<n; i++){
				if(i!=0)
					System.out.print(" ");
				System.out.print(ans[i]);
			}
			System.out.println();
		}
	}
}
