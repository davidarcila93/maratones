import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.util.StringTokenizer;


public class IQTest_25A {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int evenCount = 0, oddCount = 0;
		int lastEven = -1, lastOdd = -1;
		int aux;
		for(int i=1; i<n+1; i++){
			aux = Integer.parseInt(st.nextToken());
			if( aux%2==0 ){
				evenCount++;
				lastEven = i;
			}else{
				oddCount++;
				lastOdd = i;
			}
		}
		if( evenCount == 1 )
			System.out.println(lastEven);
		else
			System.out.println(lastOdd);
		
	}

}
