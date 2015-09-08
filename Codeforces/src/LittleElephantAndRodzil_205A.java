import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class LittleElephantAndRodzil_205A {
	
	public static class Pair implements Comparable<Pair>{

		int x, y;
		
		public Pair(int x, int y) {
			this.x = x; 
			this.y = y;
		}
		
		@Override
		public int compareTo(Pair o) {
			if( this.y != o.y )
				return this.y-o.y;
			return this.x-o.x;
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Pair v[] = new Pair[n];
		for(int i=0; i<n; i++){
			v[i] = new Pair(i+1, Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(v);
		if(n>1 && v[1].y == v[0].y)
			System.out.println("Still Rozdil");
		else
			System.out.println(v[0].x);
	}
}
