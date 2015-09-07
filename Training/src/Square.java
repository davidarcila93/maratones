import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Square {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int n;
		boolean[][] ar;
		String str;
		boolean rectangle;
		for (int caso = 1; caso <= t; caso++) {
			n=Integer.parseInt(br.readLine());
			int xmin,xmax,ymin,ymax;
			xmin=n;
			ymin=n;
			xmax=-1;
			ymax=-1;
			ar=new boolean[n][n];
			for (int i = 0; i < n; i++) {
				str=br.readLine();
				for (int j = 0; j < n; j++) {
					if(str.charAt(j)=='.')
						ar[i][j]=false;
					else {
						ar[i][j]=true;
						xmin=Math.min(xmin, i);
						xmax=Math.max(xmax, i);
						ymin=Math.min(ymin, j);
						ymax=Math.max(ymax, j);
					}
						
				}
			}
			rectangle=true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(i>=xmin && i<=xmax && j>=ymin && j<=ymax && !ar[i][j]){
						rectangle=false;
						break;
					}
				}
				if(!rectangle)
					break;
			}
			if(rectangle && xmax-xmin==ymax-ymin)
				System.out.println("Case #"+caso+": YES");
			else
				System.out.println("Case #"+caso+": NO");
			
		}
	}

}
