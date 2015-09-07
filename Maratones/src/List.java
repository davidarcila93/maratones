import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class List {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		TreeMap<String, Integer> list=new TreeMap<String, Integer>();
		String str;
		for (int i = 0; i < n; i++) {
			st=new StringTokenizer(br.readLine());
			str=st.nextToken();
			if(list.containsKey(str))
				list.put(str, list.get(str)+1);
			else
				list.put(str, 1);
		}
		for(String s: list.keySet()){
			System.out.println(s+" "+list.get(s));
			
		}
	}

}
