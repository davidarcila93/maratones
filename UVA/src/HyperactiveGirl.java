import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class HyperactiveGirl {
	static int m, n;
	static final int mod = 100000000;
	static Seg[] segments;
	static int dp[][];
	
	static int getdp(int i, int j){
		if(dp[i][j]!=-1)
			return dp[i][j];
		if( segments[j].second >= m )
			return 1;
		int ans = 0;
		for(int k=j+1; k<n+2; k++){
			if( segments[k].first <= segments[j].second && segments[k].second > segments[j].second && segments[k].first > segments[i].second )
				ans = (ans + getdp(j, k)) % mod;
		}
		
		return dp[i][j] = ans;
	}
	
	public static class Seg implements Comparable<Seg>{
		int first, second;
		public Seg(int first, int second) {
			this.first = first;
			this.second = second;
		}
		@Override
		public int compareTo(Seg o) {
			if(this.first != o.first)
				return this.first-o.first;
			return this.second-o.second;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		while(m+n!=0){
			segments = new Seg[n+2];
			segments[0] = new Seg(-2, -1);
			segments[1] = new Seg(-1, 0);
			for(int i=2; i<n+2; i++){
				st = new StringTokenizer(br.readLine());
				segments[i] = new Seg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(segments);
			dp = new int[n+2][n+2];
			for(int i=0; i<n+2; i++){
				Arrays.fill(dp[i], -1);	
			}
			
			
			System.out.println(getdp(0, 1));
			
			st = new StringTokenizer(br.readLine());
			m=Integer.parseInt(st.nextToken());
			n=Integer.parseInt(st.nextToken());
		}
		
	}
}
