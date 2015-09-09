import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CandyBags_334A {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int v[][] = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j =0; j<n; j++){
				if(i%2==0)
					v[j][i] = i*n+j+1;
				else
					v[j][i] = i*n+n-j;
			}
		}
		for(int i=0; i<n; i++){
			for(int j =0; j<n; j++){
				if(j!=0)
					System.out.print(" ");
				System.out.print(v[i][j]);
			}
			System.out.println();
		}
	}

}
