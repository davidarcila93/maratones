import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DivisionOfNlogonia_11498 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x0, y0, x, y;
		int n;
		while( (n=Integer.parseInt(br.readLine()))!=0 ){
			st = new StringTokenizer(br.readLine());
			x0=Integer.parseInt(st.nextToken());
			y0=Integer.parseInt(st.nextToken());
			for(int i=0; i<n; i++){
				st = new StringTokenizer(br.readLine());
				x=Integer.parseInt(st.nextToken());
				y=Integer.parseInt(st.nextToken());
				if(x==x0 || y==y0)
					System.out.println("divisa");
				else if(x>x0 && y>y0)
					System.out.println("NE");
				else if(x>x0 && y<y0)
					System.out.println("SE");
				else if(x<x0 && y>y0)
					System.out.println("NO");
				else
					System.out.println("SO");
			}
		}
	}

}
