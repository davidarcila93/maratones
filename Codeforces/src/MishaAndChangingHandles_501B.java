import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.TreeSet;


public class MishaAndChangingHandles_501B {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s;
		TreeMap<String, String> map = new TreeMap<String, String>();
		TreeSet<String> used = new TreeSet<String>();
		TreeSet<String> start = new TreeSet<String>();
		for(int i =0; i<n; i++){
			s = br.readLine().split(" ");
			if( !used.contains(s[0]) )
				start.add(s[0]);
			used.add(s[0]);
			used.add(s[1]);
			map.put(s[0], s[1]);
		}
		System.out.println(start.size());
		for(String str : start){
			System.out.print(str+" ");
			while( map.containsKey(str) )
				str = map.get(str);
			System.out.println(str);
		}
	}
}
