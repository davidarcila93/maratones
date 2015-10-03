import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class GCDTable {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int aux;
		for(int i=0; i<n*n; i++){
			aux = Integer.parseInt(st.nextToken());
			if( map.containsKey(aux) )
				map.put(aux, map.get(aux)+1);
			else
				map.put(aux, 1);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		Entry<Integer, Integer> entry;
		int count;
		int g;
		while(!map.isEmpty()){
			entry = map.lastEntry();
			count = 0;
			for(int i=0; i<ans.size(); i++){
				if( ans.get(i)%entry.getKey() == 0 )
					count++;
			}
			int c = 1;
			for(; c<501; c++){
				if( c*c+2*c*count == entry.getValue() )
					break;
			}
			
			
			for(int j=0; j<ans.size(); j++){
				
				g = gcd(entry.getKey(), ans.get(j));
				map.put(g, map.get(g) - 2*c);
				if( map.get(g) == 0)
					map.remove(g);
			}
			for(int j=0; j<c; j++){
				ans.add(entry.getKey());
			}
			map.remove(entry.getKey());
		}
		for(int i=0; i<n; i++){
			if(i!=0)
				System.out.print(" ");
			System.out.print(ans.get(i));
		}
	}
	public static int gcd(int a, int b){
		if(a%b == 0)
			return b;
		return gcd(b, a%b);
	}

}
