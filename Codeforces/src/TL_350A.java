import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TL_350A {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = 10000;
		int max = 0;
		int aux;
		int v = 0;
		while(st.hasMoreTokens()){
			aux = Integer.parseInt(st.nextToken());
			min = Math.min(min, aux);
			max = Math.max(max, aux);
			v = min*2;
			if(max > v)
				v = max;
		}
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			aux = Integer.parseInt(st.nextToken());
			if(aux<=v)
				v = -1;
		}
		System.out.println(v);
	}
}
