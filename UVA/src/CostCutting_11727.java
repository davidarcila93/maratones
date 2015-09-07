import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class CostCutting_11727 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> a;
		for(int i=1; i<=n; i++){
			st=new StringTokenizer(br.readLine());
			a= new ArrayList<Integer>();
			a.add(Integer.parseInt(st.nextToken()));
			a.add(Integer.parseInt(st.nextToken()));
			a.add(Integer.parseInt(st.nextToken()));
			Collections.sort(a);
			System.out.println("Case "+i+": "+a.get(1));
		}
		
	}

}
