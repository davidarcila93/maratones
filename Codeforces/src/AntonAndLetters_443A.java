import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class AntonAndLetters_443A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().replaceAll("\\{", "");
		s = s.replaceAll("\\}", "");
		s = s.replaceAll(", ", " ");
		StringTokenizer st = new StringTokenizer(s);
		TreeSet<String> set = new TreeSet<String>();
		while(st.hasMoreTokens()){
			set.add(st.nextToken());
		}
		System.out.println(set.size());
	}
}
