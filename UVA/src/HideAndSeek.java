import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class HideAndSeek {

	static Pair pivot, curPoint;
	static final double EPS = 1e-9;
	public static class Pair implements Comparable<Pair>{
		int x, y, id, type; // type 0 start, 1 end, 2 point
		public Pair(int x, int y, int id, int type ) {
			this.x = x;
			this.y = y;
			this.id = id;
			this.type = type;
		}
		@Override
		public int compareTo(Pair o) {
			if(above(this) && below(o))
				return -1;
			if(below(this) && above(o))
				return 1;
			int cross = this.x*o.y - this.y*o.x;
			return -cross;
		}
	}
	
	public static boolean above(Pair p){
		if(p.y == 0){
			if(p.x >= 0)
				return true;
			return false;
		}
		return p.y>0;
	}
	
	public static boolean below(Pair p){
		return !above(p);
	}
	
	public static class Wall implements Comparable<Wall>{
		Pair from, to;
		Line2D wall;
		public Wall(Pair from, Pair to) {
			this.from = from;
			this.to = to;
			this.wall = new Line2D.Double(from.x, from.y, to.x, to.y);
		}
		@Override
		public String toString() {
			return ""+from.id;
		}
		@Override
		public int compareTo(Wall o) {
			if(this.from.id == o.from.id)
				return 0;
			double dirx = curPoint.x;
			double diry = curPoint.y;
			double x1, y1, x2, y2;
			double h = Math.hypot(dirx, diry);
			dirx = dirx/h;
			diry = diry/h;
			double min = 0, max = 2*1e6, mid1, mid2, aux;
			while(max-min>EPS){
				aux = (max-min)/3.;
				mid1 = min+aux;
				mid2 = min+2*aux;
				if( this.wall.ptLineDist(pivot.x + dirx*mid1, pivot.y + diry*mid1) < this.wall.ptLineDist(pivot.x + dirx*mid2, pivot.y + diry*mid2) )
					max = mid2;
				else
					min = mid1;
			}
			x1 = pivot.x + dirx*min;
			y1 = pivot.y + diry*min;
			min = 0;
			max = 2*1e6;
			while(max-min>EPS){
				aux = (max-min)/3.;
				mid1 = min+aux;
				mid2 = min+2*aux;
				if( o.wall.ptLineDist(pivot.x + dirx*mid1, pivot.y + diry*mid1) < o.wall.ptLineDist(pivot.x + dirx*mid2, pivot.y + diry*mid2) )
					max = mid2;
				else
					min = mid1;
			}
			x2 = pivot.x + dirx*min;
			y2 = pivot.y + diry*min;
			
			if(Math.hypot(x1-pivot.x, y1-pivot.y) - Math.hypot(x2-pivot.x, y2-pivot.y)>EPS)
				return 1;
			if(Math.hypot(x1-pivot.x, y1-pivot.y) - Math.hypot(x2-pivot.x, y2-pivot.y)<-EPS)
				return -1;
			return 0;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int S, K, W;
		Pair[] kids;
		Wall[] walls;
		Pair[] events;
		String str;
		TreeSet<Wall> usedWalls = new TreeSet<Wall>();
		TreeSet<Integer> idUsedWalls = new TreeSet<Integer>();
		int id;
		Pair from, to, tmp;
		while((str = br.readLine())!=null){
			st = new StringTokenizer(str);
			S=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			
			kids = new Pair[K];
			walls = new Wall[W];
			events = new Pair[K-1+2*W];
			for(int i=0; i<K; i++){
				st = new StringTokenizer(br.readLine());
				kids[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i, 2);
			}
			for(int i=0; i<W; i++){
				st = new StringTokenizer(br.readLine());
				walls[i] = new Wall( new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i, 0) , new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i, 0) );
			}
			int ans;
			for(int i=0; i<S; i++){
				id=0;
				pivot = kids[i];
				usedWalls.clear();
				idUsedWalls.clear();
				for(int j=0; j<K; j++){
					if(i==j)
						continue;
					events[id++] = new Pair(kids[j].x-pivot.x, kids[j].y-pivot.y, j, 2);
				}
				for(int j=0; j<W; j++){
					from = new Pair(walls[j].from.x, walls[j].from.y, walls[j].from.id, walls[j].from.type);
					from.x-=pivot.x;
					from.y-=pivot.y;
					to = new Pair(walls[j].to.x, walls[j].to.y, walls[j].to.id, walls[j].to.type);
					to.x-=pivot.x;
					to.y-=pivot.y;
					if(from.x*to.y - from.y*to.x < 0){
						tmp=from;
						from = to;
						to = tmp;
					}
					from.type = 0;
					to.type = 1;
					events[id++] = from;
					events[id++] = to;
				}
				Arrays.sort(events);
				ans = 0;
				for(int j=0; j<events.length; j++){
					curPoint = events[j];
					if(events[j].type==2){
						
					}else if(events[j].type==0){
						usedWalls.add(walls[events[j].id]);
						idUsedWalls.add(events[j].id);
					}else{
						if(idUsedWalls.contains(events[j].id)){
							usedWalls.remove(walls[events[j].id]);
							idUsedWalls.remove(events[j].id);
						}
					}
				}
				for(int j=0; j<events.length; j++){
					curPoint = events[j];
					if(events[j].type==2){
//						System.out.println("IdPoint "+events[j].id);
						if(usedWalls.isEmpty()){
							ans++;
						}else{
//							System.out.println("******* "+usedWalls.first().from.id);
							if( !usedWalls.first().wall.intersectsLine(pivot.x, pivot.y, curPoint.x + pivot.x, curPoint.y + pivot.y)){
//								System.out.println("Not BLocked");
								ans++;
							}
						}
					}else if(events[j].type==0){
//						System.out.println("Entra SEg "+events[j].id);
						usedWalls.add(walls[events[j].id]);
						idUsedWalls.add(events[j].id);
//						System.out.println(usedWalls.toString());
					}else{
						if(idUsedWalls.contains(events[j].id)){
//							System.out.println("Sale SEg "+events[j].id);
							usedWalls.remove(walls[events[j].id]);
							idUsedWalls.remove(events[j].id);
						}
					}
				}
				System.out.println(ans);
			}
		}
	}
}
