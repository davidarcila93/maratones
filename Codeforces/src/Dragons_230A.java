import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Dragons_230A {
	
	public static class Pair implements Comparable<Pair>{
		
		int x, y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Pair o) {
			if( this.x!= o.x)
				return this.x-o.x;
			return this.y-o.y;
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s, n;
		s = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		Pair[] v = new Pair[n];
		int x, y;
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			v[i] = new Pair(x, y);
		}
		Arrays.sort(v);
		boolean can = true;
		for(int i=0; i<n; i++){
			if( v[i].x >= s ){
				can =false;
				break;
			}
			s+=v[i].y;
		}
		if(can)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
