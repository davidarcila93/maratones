import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Horseshoe_228A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeSet<Integer> shoes = new TreeSet<Integer>();
		while(st.hasMoreTokens()){
			shoes.add(Integer.parseInt(st.nextToken()));
		}
		System.out.println( (4-shoes.size()) );
	}
}
