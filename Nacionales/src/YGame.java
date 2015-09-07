import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class YGame {

	static int parent[];
	static int weight[];
	static int xStep[] = new int[]{1, -1, 1, -1, 0, 0};
	static int yStep[] = new int[]{-1, 1, 0, 0, 1, -1};
	
	static void join(int a, int b){
		a=getParent(a);
		b=getParent(b);
		if(a!=b){
			if(weight[a]<weight[b]){
				parent[a]=b;
				weight[b]+=weight[a];
			}else{
				parent[b]=a;
				weight[a]+=weight[b];
			}
		}
	}
	
	static int getParent(int a){
		while(parent[a]!=a){
			parent[a] = parent[ parent[a] ];
			a = parent[a];
		}
		return a;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n, m;
		boolean black[][];
		int x, y;
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			if(m==0 && n ==0)
				return;
			n++;
			black=new boolean[n][n];
			for(int i=0; i<n; i++){
				Arrays.fill(black[i], false);
			}
			for(int i=0; i<m; i++){
				st=new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				black[x][y] = true;
			}
			
			
			int size =  (n*(n+1));
//			int xSide=size;
//			int ySide=size+1;
//			int zSide=size+2;
			parent = new int[size+3];
			for(int i=0; i<size+3; i++){
				parent[i]=i;
			}
			weight = new int[size+3];
			Arrays.fill(weight, 1);
			
//			for(int i=0; i<n; i++){
//				if(black[0][i]){
//					join(xSide, i);
//					System.out.println("x 0 "+i);
//				}
//				if(black[i][0]){
//					join(ySide, i*n);
//					System.out.println("y "+i+" 0");
//				}
//				if(black[i][n-i-1]){
//					join(zSide, i*n+n-i-1);
//					System.out.println("z "+i+" "+(n-i-1));
//				}
//			}
			
			int actX, actY;
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(black[i][j]){
						for(int k=0; k<xStep.length; k++){
							actX = i+xStep[k];
							actY = j+yStep[k];
							if( actX >= 0 && actX < n && actY >= 0 && actY <n && actX+actY<n && black[actX][actY])
								join(i*n+j, actX*n+actY);
						}
					}
				}
			}
//			System.out.println(Arrays.toString(parent));
			
			boolean ws = false;
			for(int i=0; i<n; i++){
				if(!black[0][i])
					continue;
				for(int j=0; j<n; j++){
					if(!black[j][0])
						continue;
					if(getParent(i)!=getParent(j*n))
						continue;
					for(int k=0; k<n; k++){
						if(!black[k][n-k-1])
							continue;
						if(getParent(j*n)==getParent(k*n+n-k-1)){
							ws=true;
						}
					}
				}
			}
//			System.out.println(getParent(xSide)+" "+getParent(ySide)+" "+getParent(zSide));
			if(ws)
				System.out.println("Benny");
			else
				System.out.println("Willy");
				
		}
	}
}
