import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class KefaAndCompany {
	
	public static class Pair implements Comparable<Pair>{
		long money, factor;
		
		public Pair(long money, long factor) {
			this.money = money;
			this.factor = factor;
		}
		
		@Override
		public int compareTo(Pair o) {
			if( o.money != this.money )
				return (int)(this.money-o.money);
			return (int)(this.factor - o.factor);
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, d;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		Pair[] v = new Pair[n+1];
		v[0] = new Pair(0, 0);
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			v[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(v);
		
//		for(int i=0; i<v.length; i++){
//			System.out.println(v[i].money+" "+v[i].factor);
//		}
		long ans = 0;
		long cur = 0;
		
		int a = 1, b = 1;
		
		for(; a<n+1; a++){
			cur -= v[a-1].factor;
			while( b < v.length && v[b].money < v[a].money+d){
				cur+=v[b].factor;
				b++;
				ans = Math.max(ans, cur);
			}
		}
		System.out.println(ans);
		
	}
}
