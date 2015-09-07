import java.io.*;
import java.util.*;


public class Garbage {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][][] ar;
		int[][][] sq;
		int max;
		int cur;
		boolean empty;
		int t=Integer.parseInt(br.readLine());
		String str;
		int a,b,c;
		for (int i = 0; i < t; i++) {
			br.readLine();
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			ar=new int[a][b][c];
			sq=new int[a+1][b+1][c+1];
			st=new StringTokenizer(br.readLine());
			for (int x = 0; x < a; x++) {
				for (int y = 0; y < b; y++) {
					for (int z = 0; z < c; z++) {
						ar[x][y][z]=Integer.parseInt(st.nextToken());
					}
				}
			}
			
			for (int x = a-1; x >= 0 ; x--) {
				for (int y = b-1; y >= 0; y--) {
					for (int z = c-1; z >= 0; z--) {
						sq[x][y][z]=ar[x][y][z]+sq[x+1][y][z]+sq[x][y+1][z]-sq[x+1][y+1][z];
					}
				}
			}
			
			max=ar[0][0][0];
			
			for (int xmin = 0; xmin < a; xmin++) {
				for (int xmax = xmin; xmax < a; xmax++) {
					for (int ymin = 0; ymin < b; ymin++) {
						for (int ymax = ymin; ymax < b; ymax++) {
							empty=true;
							cur=0;
							for (int j = 0; j < c; j++) {
								if(empty){
									cur=sq[xmin][ymin][j]-sq[xmin][ymax+1][j]-sq[xmax+1][ymin][j]+sq[xmax+1][ymax+1][j];
									empty =false;
								}
								else
									cur+=sq[xmin][ymin][j]-sq[xmin][ymax+1][j]-sq[xmax+1][ymin][j]+sq[xmax+1][ymax+1][j];
								max=Math.max(max, cur);
								
								if(cur<0){
									cur=0;
									empty=true;
								}
									
							}
						}
					}
				}
			}
			System.out.println(max);
			
			
		}
		
	}

}
