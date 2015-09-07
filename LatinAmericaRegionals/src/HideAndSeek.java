import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class HideAndSeek {
	
	static class Event implements Comparable<Event>{
		// type 0 start, 1 end, 2 kid
		int type;
		double angle;
		int id;
		public Event(double angle, int type, int id) {
			this.angle = angle;
			this.type = type;
			this.id = id;
		}
		@Override
		public int compareTo(Event o) {
			if (this.angle < o.angle){
				return -1;
			}
			return 1;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int s, k, w;
		ArrayList<Event> ar;
		ArrayList<Integer> orderedSegments;
		int[] xStart, yStart, xEnd, yEnd, x, y;
		while ((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			s=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			x = new int[k];
			y = new int[k];
			xStart = new int[w];
			yStart = new int[w];
			xEnd = new int[w];
			yEnd = new int[w];
			for(int i=0; i<k; i++){
				st=new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<w; i++){
				st=new StringTokenizer(br.readLine());
				xStart[i] = Integer.parseInt(st.nextToken());
				yStart[i] = Integer.parseInt(st.nextToken());
				xEnd[i] = Integer.parseInt(st.nextToken());
				yEnd[i] = Integer.parseInt(st.nextToken());
			}
			
		}
	}

}
