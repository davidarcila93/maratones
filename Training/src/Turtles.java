import java.io.*;
import java.util.*;



public class Turtles {
	static int posx[];
	static int posy[];
	static int auxposx[];
	static int auxposy[];
	static int[][] perm={{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}};
	static int[] actperm;
	static int min;
	static int time;
	static int[] mx,my;
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		while(true){
			posx=new int[4];
			posy=new int[4];
			mx=new int[4];
			my=new int[4];
			min=1000000000;
			st=new StringTokenizer(br.readLine());
			posx[0]=Integer.parseInt(st.nextToken());
			posy[0]=Integer.parseInt(st.nextToken());
			auxposx=new int[4];
			auxposy=new int[4];
			if(posx[0]==0 && posy[0]==0)
				break;
			for (int i = 1; i < 4; i++) {
				st=new StringTokenizer(br.readLine());
				posx[i]=Integer.parseInt(st.nextToken());
				posy[i]=Integer.parseInt(st.nextToken());
				if(st.nextToken().contentEquals("D"))
					mx[i]=1;
				else
					my[i]=1;
			}
//			auxposx=posx;
//			auxposy=posy;
			
			
			for (int i = 0; i < 4; i++) {
				auxposx[i]=posx[i];
				auxposy[i]=posy[i];
			}
			
			for (int i = 0; i < 6; i++) {
				for (int ii = 0; ii < 4; ii++) {
					posx[ii]=auxposx[ii];
					posy[ii]=auxposy[ii];
				}
				actperm=perm[i];
				time=0;
				for (int j = 0; j < 3; j++) {
					
					get(actperm[j]);
				}
				min=Math.min(min, time);
			}
			System.out.println(min);
			
		}
	}
	private static void get(int j) {
		int dx,dy;
		int aux[]=new int[2];
		
		dx=Math.abs(posx[0]-posx[j]);
		dy=Math.abs(posy[0]-posy[j]);
		if(mx[j]==1 && posx[j]<posx[0] && 2*dx> dy)
			aux[0]=(dy+dx+2)/3;
		else if(mx[j]==1 && posx[j]<posx[0])
			aux[0]=dy-dx;
		else if(mx[j]==1)
			aux[0]=dy+dx;
		else if(my[j]==1 && posy[j]<posy[0] && 2*dy> dx)
			aux[1]=(dy+dx+2)/3;
		else if(my[j]==1 && posy[j]<posy[0])
			aux[1]=dx-dy;
		else if(my[j]==1)
			aux[1]=dy+dx;
		
		posx[0]=posx[j]+(aux[0]+aux[1])*mx[j];
		posy[0]=posy[j]+(aux[0]+aux[1])*my[j];
		
		for (int i = 1; i < 4; i++) {
			posx[i]+=(aux[0]+aux[1])*mx[i];
			posy[i]+=(aux[0]+aux[1])*my[i];
		}
		time+=aux[0]+aux[1];
		
	}

}
