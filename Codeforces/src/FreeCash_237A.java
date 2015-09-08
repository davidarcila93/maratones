import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class FreeCash_237A {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		int h, m, aux;
		StringTokenizer st;
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			aux = h*60+m;
			map.put(aux, map.get(aux)!=null ? map.get(aux)+1 : 1);
			ans = Math.max(ans, map.get(aux));
		}
		System.out.println(ans);
	}
}
