import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main_VirtualFriends {
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
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> id;
		StringTokenizer st;
		int cases, n, a, b;
		String str1, str2;
		int index;
		cases=Integer.parseInt(br.readLine());
		for (int i = 0; i < cases; i++) {
			id=new TreeMap<String, Integer>();
			n=Integer.parseInt(br.readLine());
			parent=new int[2*n];
			size=new int[2*n];
			for (int j = 0; j < parent.length; j++) {
				parent[j]=j;
				size[j]=1;
			}
			
			
			index=0;
			for (int j = 0; j < n; j++) {
				st=new StringTokenizer(br.readLine());
				str1=st.nextToken();
				if(id.containsKey(str1))
					a=id.get(str1);
				else{
					a=index;
					id.put(str1, index);
					index++;
				}
					
				str1=st.nextToken();
				
				if(id.containsKey(str1))
					b=id.get(str1);
				else{
					b=index;
					id.put(str1, index);
					index++;
				}
				connect(a, b);
				System.out.println(size[root(a)]);
			}
		}
	}
}
