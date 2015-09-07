import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Horse {
	static int movx[]={1,1,-1,-1,2,2,-2,-2};
	static int movy[]={2,-2,2,-2,1,-1,1,-1};
	
	public static class Pair{
		int x,y, steps, captured;
		TreeSet<Integer> set;
		
		public Pair(int x,  int y, int steps, int captured){
			this.x=x;
			this.y=y;
			this.steps=steps;
			this.captured=captured;
			set=new TreeSet<Integer>();
		}
		
		@Override
		public String toString() {
			
			return x+" "+y+" "+steps+" "+captured;
		}

		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n,m,k;
		Queue<Pair> q;
		int[][] ar;
		int a=0,b=0;
		Pair p, aux;
		String str;
		while(true){
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			if(n==0 && m==0 && k==0)
				break;
			ar=new int[n][m];
			q=new LinkedList<Pair>();
			for (int i = 0; i < n; i++) {
				str=br.readLine();
				for (int j = 0; j < m; j++) {
					switch (str.charAt(j)) {
					case 'P':
						ar[i][j]=1;
						break;
					
					case '#':
						ar[i][j]=-1;
						break;
						
					case 'C':
						ar[i][j]=2;
						a=i;
						b=j;
						q.add(new Pair(i, j, 0, 0));
						break;
						
					default:
						break;
					}	
				}
			}
			while(!q.isEmpty()){
				p=q.poll();
				if(p.x==a && p.y==b && p.captured==k){
					System.out.println(p.steps);
					break;
				}
				for (int i = 0; i < movx.length; i++) {
					if(p.x+movx[i]<0 || p.x+movx[i]>=n ||p.y+movy[i]<0 || p.y+movy[i]>=m)
						continue;
					if(ar[p.x+movx[i]][p.y+movy[i]]==1 && !p.set.contains(100*p.x+p.y)){
						aux=new Pair(p.x+movx[i], p.y+movy[i], p.steps+1, p.captured+1);
						aux.set.add(100*p.x+p.y);
						for (int l: p.set) {
							aux.set.add(l);
						}
						q.add(aux);
					}
						
					else if(ar[p.x+movx[i]][p.y+movy[i]]==0){
						aux=new Pair(p.x+movx[i], p.y+movy[i], p.steps+1, p.captured);
						for (int l: p.set) {
							aux.set.add(l);
						}
						q.add(aux);
					}
						
				}
			}
		}
	}

}
