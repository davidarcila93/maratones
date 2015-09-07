import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class QueueAtTheSchool_266B {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n , t;
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		boolean line[][] = new boolean[t+1][n];
		String str  = br.readLine();
		for(int i=0; i<str.length(); i++){
			line[0][i] = str.charAt(i)=='G';
		}
		for(int i=1; i<=t; i++){
			for(int id = n-1; id>=0; id--){
				line[i][id] = line[i-1][id];
			}
			for(int id = n-1; id>0; id--){
				if( line[i-1][id] && !line[i-1][id-1]){
					line[i][id] = false;
					line[i][id-1] = true;
				}
			}
		}
		
		for(int i=0; i<n; i++){
			System.out.print(line[t][i] ? "G" : "B");
		}
		
	}
}
