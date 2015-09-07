import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class carpets {
	static int[] x, y;
	static int carpets;
	static boolean[][]  table;
	static int W, H;
	
	public static int[] getFirstUnused(){
		for(int i=0; i<W; i++){
			for(int j=0; j<H; j++){
				if(!table[i][j])
					return new int[]{i, j};
			}
		}
		return null;
	}
	
	public static void fill(int x, int y, int dx, int dy, boolean flag){
		for(int i=x; i<x+dx; i++){
			for(int j=y; j<y+dy; j++){
				table[i][j] = flag;
			}
		}
	}
	
	public static boolean check(int x, int y, int dx, int dy){
		if(x+dx>W)
			return false;
		if(y+dy>H)
			return false;
		for(int i=x; i<x+dx; i++){
			for(int j=y; j<y+dy; j++){
				if(table[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static boolean dfs(int mask){
		int[] pos = getFirstUnused();
		if(pos==null){
			return true;
		}
		for(int i=0; i<carpets; i++){
			if( (mask & (1<<i)) !=0)
				continue;
			
			if(check(pos[0], pos[1], x[i], y[i])){
				fill(pos[0], pos[1], x[i], y[i], true);
				if(dfs(mask | (1<<i)))
					return true;
				fill(pos[0], pos[1], x[i], y[i], false);
			}
			
			if(check(pos[0], pos[1], y[i], x[i])){
				fill(pos[0], pos[1], y[i], x[i], true);
				if(dfs(mask | (1<<i)))
					return true;
				fill(pos[0], pos[1], y[i], x[i], false);
			}
			
		}
		return false;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		table = new boolean[W][H];
		int total = Integer.parseInt(br.readLine());
		x = new int[10];
		y = new int[10];
		carpets = 0;
		int a, w, h;
		for(int i=0; i<total; i++){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			for(int j=0; j<a; j++){
				x[carpets]=w;
				y[carpets]=h;
				carpets++;
			}
		}
		if( dfs(0) )
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
