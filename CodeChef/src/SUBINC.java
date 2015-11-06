import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SUBINC {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long total, cur = 0;
		int T = Integer.parseInt(br.readLine());
		int n;
		long aux;
		long last = -1;
		for(int k=0; k<T; k++){
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			total = 0;
			cur = 0;
			for(int i=0; i<n; i++){
				aux = Long.parseLong(st.nextToken());
				if( i==0 || aux < last ){
					total += (cur*(cur+1))/2;
					cur = 1;
				}else
					cur++;
				last = aux;
			}
			total += (cur*(cur+1))/2;
			System.out.println(total);
		}
	}
}
