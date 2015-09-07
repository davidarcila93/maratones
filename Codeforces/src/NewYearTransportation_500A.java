import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class NewYearTransportation_500A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, t;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		int[] portal = new int[n-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n-1; i++){
			portal[i] = Integer.parseInt(st.nextToken());
		}
		t--;
		int start = 0;
		while(start != n-1){
			start += portal[start];
			if(start == t){
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
		
	}
}
