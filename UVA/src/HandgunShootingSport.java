import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class HandgunShootingSport {
	
	public static class Event implements Comparable<Event>{
		int x, y, id, state; // state 0 start 1 end
		public Event(int x, int y, int id, int state) {
			this.x = x;
			this.y = y;
			this.id = id;
			this.state = state;
		}
		@Override
		public int compareTo(Event o) {
			int cross = this.x*o.y - this.y*o.x;
			if(cross != 0)
				return -cross;
			return this.state - o.state;
		}
	}
	
	static Event[] ar;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int b;
		int x, y;
		int x1, y1;
		int ans;
		TreeSet<Integer> open;
		while(true){
			b=Integer.parseInt(br.readLine());
			if(b==0)
				return;
			ar = new Event[2*b];
			for(int i=0; i<b; i++){
				st = new StringTokenizer(br.readLine());
				x=Integer.parseInt(st.nextToken());
				y=Integer.parseInt(st.nextToken());
				x1=Integer.parseInt(st.nextToken());
				y1=Integer.parseInt(st.nextToken());
				int cross = x*y1-y*x1;
				
				if(cross>0){
					ar[2*i] = new Event(x, y, i, 0);
					ar[2*i+1] = new Event(x1, y1, i, 1);
				}else{
					ar[2*i] = new Event(x, y, i, 1);
					ar[2*i+1] = new Event(x1, y1, i, 0);
				}
			}
			Arrays.sort(ar);
			open = new TreeSet<Integer>();
			Event e;
			ans = 0;
			for(int i=0; i<ar.length; i++){
				e= ar[i];
//				System.out.println(e.x+" "+e.y+" "+e.id+" "+e.state);
				if(e.state == 0)
					open.add(e.id);
				else if(open.contains(e.id)){
//					System.out.println("ADD");
					ans++;
					open.clear();
				}
			}
			System.out.println(ans);
		}
	}
}
