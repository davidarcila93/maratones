import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class OlesyaandRodion {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, t;
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		int r = 1;
		for(int i=1; i<n; i++){
			r = (r*10)%t;
		}
		int k=0;
		while( r != 0){
			r = (r+1)%t;
			k++;
		}
		if(n==1 && t==10)
			System.out.println("-1");
		else if(n==1)
			System.out.println((k+1));
		else{
			System.out.print("1");
			for(int i=1; i<n-1; i++){
				System.out.print("0");
			}
			System.out.println(k);
		}
		
		
	}
}
