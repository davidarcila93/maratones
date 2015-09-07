import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main_DarkRoads {
	
	static int[] parent;
	static int[] size;
	
	public static int root(int a){
		parent[a]=parent[parent[a]];
		if(a==parent[a])
			return a;
		return root(parent[a]);
	}
	
	public static void connect(int a, int b){
		int pa, pb;
		pa=root(a);
		pb=root(b);
		if(pa==pb)
			return;
		if(size[pa]>size[pb]){
			parent[pb]=pa;
			size[pa]+=size[pb];
		}
		else{
			parent[pa]=pb;
			size[pb]+=size[pa];
		}
	}
	
	public static boolean query(int a, int b){
		if(root(a)==root(b))
			return true;
		return false;
	}
	
	public static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int cost;
		Edge(int start, int end, int cost){
			this.start=start;
			this.end=end;
			this.cost=cost;
		}
		
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n,m;
		int a, b, c;
		ArrayList<Edge> edges;
		String str;
		while(!(str=br.readLine().trim()).contentEquals("0 0")){
			st=new StringTokenizer(str);
			m=Integer.parseInt(st.nextToken());
			n=Integer.parseInt(st.nextToken());
			edges=new ArrayList<Edge>();
			parent=new int[m];
			size=new int[m];
			for (int i = 0; i < parent.length; i++) {
				parent[i]=i;
				size[i]=1;
			}
			int total=0;
			int MST=0;
			for (int i = 0; i < n; i++) {
				st=new StringTokenizer(br.readLine());
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				c=Integer.parseInt(st.nextToken());
				total+=c;
				edges.add(new Edge(a, b, c));
			}
			Collections.sort(edges);
			for (int i = 0; i < edges.size(); i++) {
				a=edges.get(i).start;
				b=edges.get(i).end;
				c=edges.get(i).cost;
				if(query(a,b))
					continue;
				else{
					connect(a,b);
					MST+=c;
				}
			}
			System.out.println((total-MST));
		}
		
		
	}
}
