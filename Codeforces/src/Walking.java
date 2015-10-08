import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;


public class Walking {
	
	public static class Print implements Comparable<Print>{
		
		int type;
		int pos;
		
		public Print( int type, int pos) {
			this.type = type;
			this.pos = pos;
		}
		
		@Override
		public int compareTo(Print o) {
			if( this.type != o.type )
				return this.type - o.type;
			return this.pos - o.pos;
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		TreeSet<Print> set = new TreeSet<Print>();
		for(int i = 0; i<s.length(); i++){
			set.add(new Print( s.charAt(i) == 'L' ? 0 : 1, i+1 ));
		}
		int start = -1;
		int[] path = new int[ (int)(s.length()+1) ];
		
		Print aux;
		Print p = set.first();
		start = p.pos;
		int count = 0;
		while(true){
			set.remove(p);
			p.type = 1-p.type;
			aux = set.ceiling(p);
			if( aux != null && p.type == aux.type){
				path[ p.pos ] = aux.pos;
				p = aux;
			}else{
				p.pos = 0;
				aux = set.ceiling(p);
				if( aux != null && p.type == aux.type){
					path[ p.pos ] = aux.pos;
					p = aux;
					count++;
				}else
					break;
			}
		}
		
		if( !set.isEmpty() ){
			count++;
			aux = set.first();
			path[ aux.pos ] = start;
			start = aux.pos;
		}
		System.out.println(count);
		System.out.print(start);
		while( path[start] != 0){
			start = path[start];
			System.out.print(" "+start);
		}
		
	}
}
