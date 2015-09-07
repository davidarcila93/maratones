import java.io.BufferedReader;	
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class LazyFrog {
	
	public static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost){
			this.x=x;
			this.y=y;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.cost!=o.cost)
				return this.cost-o.cost;
			return 0;
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Node> pq;
		int C, R, Cf, Rf, Ct, Rt, W;
		int c1, r1, c2, r2;
		int x,y,c;
		int INF=1000000000;
		boolean marsh[][];
		int cost[][];
		int xstep[]={-2,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,0,0,0,1,1,1,1,1,2,2,2,2,2};
		int ystep[]={-2,-1,0,1,2,-2,-1,0,1,2,-2,-1,1,2,-2,-1,0,1,2,-2,-1,0,1,2};
		int calories[]={7,6,5,6,7,6,3,2,3,6,5,2,2,5,6,3,2,3,6,7,6,5,6,7};
		while(true){
			st=new StringTokenizer(br.readLine());
			C=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			if(C==0 && R==0) break;
			marsh=new boolean[C][R];
			cost=new int[C][R];
			
			for (int i = 0; i < C; i++) {
				Arrays.fill(cost[i], INF);
			}
			
			st=new StringTokenizer(br.readLine());
			
			Cf=Integer.parseInt(st.nextToken())-1;
			Rf=Integer.parseInt(st.nextToken())-1;
			Ct=Integer.parseInt(st.nextToken())-1;
			Rt=Integer.parseInt(st.nextToken())-1;
			
			pq=new PriorityQueue<Node>();
			pq.add(new Node(Cf, Rf, 0));
			cost[Cf][Rf]=0;
			
			W=Integer.parseInt(br.readLine());
			
			for (int i = 0; i < W; i++) {
				st=new StringTokenizer(br.readLine());
				c1=Integer.parseInt(st.nextToken())-1;
				r1=Integer.parseInt(st.nextToken())-1;
				c2=Integer.parseInt(st.nextToken())-1;
				r2=Integer.parseInt(st.nextToken())-1;
				for (int j = c1; j <=c2 ; j++) {
					marsh[j][r1]=marsh[j][r2]=marsh[j][Math.min(r1+1, r2)]=marsh[j][Math.max(r2-1, r1)]=true;
				}
				for (int j = r1; j <=r2 ; j++) {
					marsh[c1][j]=marsh[c2][j]=marsh[Math.min(c1+1, c2)][j]=marsh[Math.max(c2-1, c1)][j]=true;
				}
			}
			
			while(!pq.isEmpty()){
				Node n=pq.poll();
				x=n.x;
				y=n.y;
				c=n.cost;
				if(cost[x][y]!=c)
					continue;
				for (int i = 0; i < xstep.length; i++) {
					if(0<=x+xstep[i] && x+xstep[i]<C && 0<=y+ystep[i] && y+ystep[i]<R && !marsh[x+xstep[i]][y+ystep[i]] && c+calories[i]<cost[x+xstep[i]][y+ystep[i]]){
						cost[x+xstep[i]][y+ystep[i]]=c+calories[i];
						pq.add(new Node(x+xstep[i], y+ystep[i], c+calories[i]));
					}
				}
			}
			
			if(cost[Ct][Rt]==INF)
				System.out.println("impossible");
			else
				System.out.println(cost[Ct][Rt]);
			
			
			
			
			
		}
		
	}

}
