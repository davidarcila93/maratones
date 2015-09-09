import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Worms_474B {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] pile = new int[1000100];
		int id = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int aux;
		for(int k =0; k<n; k++){
			aux = Integer.parseInt(st.nextToken());
			for(int i=0; i<aux; i++){
				pile[id++] = k+1;
			}
		}
		
		br.readLine();
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			System.out.println( pile[ Integer.parseInt(st.nextToken()) ] );
		}
	}

}
