import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Portuñol {
	
	public static class Trie{
		int[][] t;
		int nodes = 0;
		public Trie() {
			t = new int[100005][26];
			clear();
		}
		
		public void clear(){
			Arrays.fill(t[0], -1);
			nodes = 0;
		}
		
		public void add(String s, boolean reverse){
			int state = 0;
			if(!reverse){
				for(int i=0; i<s.length(); i++){
					int k = s.charAt(i)-'a';
					if( t[state][k] == -1 ){
						nodes++;
						t[state][k] = nodes;
						Arrays.fill(t[nodes], -1);
					}
					state = t[state][k]; 
				}
			}else{
				for(int i=s.length()-1; i>=0; i--){
					int k = s.charAt(i)-'a';
					if( t[state][k] == -1 ){
						nodes++;
						t[state][k] = nodes;
						Arrays.fill(t[nodes], -1);
					}
					state = t[state][k]; 
				}
			}
			
		}
	}
	
	public static void prefixDfs(int node, int depth){
		for(int i=0; i<26; i++){
			if(prefix.t[node][i] == -1)
				continue;
			if(depth > 0)
				start[i]++;
			prefixDfs(prefix.t[node][i], depth+1);
		}
	}
	
	public static void sufixDfs(int node, int depth){
		for(int i=0; i<26; i++){
			if(sufix.t[node][i] == -1)
				continue;
			ans+=prefix.nodes;
			if(depth > 0)
				ans-=start[i];
			sufixDfs(sufix.t[node][i], depth+1);
		}
	}
	
	static Trie prefix, sufix;
	static int start[];
	static long ans;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p, s;
		StringTokenizer st;
		prefix = new Trie();
		sufix = new Trie();
		while(true){
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			if(p+s==0)
				break;
			prefix.clear();
			sufix.clear();
			start = new int[26];
			for(int i=0; i<p; i++){
				prefix.add(br.readLine(), false);
			}
			for(int i=0; i<s; i++){
				sufix.add(br.readLine(), true);
			}
			prefixDfs(0, 0);
			ans = 0;
			sufixDfs(0, 0);
			System.out.println(ans);
		}
		
	}

}
