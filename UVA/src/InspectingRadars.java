import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class InspectingRadars {
	static int bits[][];
	static int n, r, e;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int dist, theta;
		int h, a;
		while(true){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			if(n+r==0)
				return;
			bits = new int[360][r];
			for(int i=0; i<n; i++){
				st = new StringTokenizer(br.readLine());
				dist = Integer.parseInt(st.nextToken());
				theta = Integer.parseInt(st.nextToken());
				update(theta, dist);
			}
			e = Integer.parseInt(br.readLine());
			int ans;
			int acu;
			for(int i=0; i<e; i++){
				st = new StringTokenizer(br.readLine());
				h = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				ans = 0;
				for(int pos = 1; pos<r; pos++){
					acu = 0;
					for(int angle = 0; angle<=a; angle++){
						acu+= read(angle, Math.min(r-1, pos+h-1));
						acu-= read(angle, pos-1);
						ans = Math.max(ans, acu);
					}
					for(int angle=0; angle <360; angle++){
						acu-= read(angle, Math.min(r-1, pos+h-1));
						acu+= read(angle, pos-1);
						
						acu+=read(angle+a+1, Math.min(r-1, pos+h-1));
						acu-= read(angle+a+1, pos-1);
						ans = Math.max(ans, acu);
					}
				}
				System.out.println(ans);
			}
		}
	}
	
	public static void update(int angle, int pos){
		while(pos<r){
			bits[angle][pos]++;
			pos += (pos & -pos);
		}
	}
	
	public static int read(int angle, int pos){
		angle = angle%360;
		int sum = 0;
		while(pos>0){
			sum += bits[angle][pos];
			pos -= (pos & -pos);
		}
		return sum;
	}
	
}
