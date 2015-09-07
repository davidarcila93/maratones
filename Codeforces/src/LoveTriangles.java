import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class LoveTriangles {
	
	static int n, m;
	static ArrayList<ArrayList<int[]>> adj;
	
	static int cc=0;
	static int[] visited;
	
	
	static boolean visit(int v){
		for(int[] a: adj.get(v)){
			if(visited[a[0]]==-1){
				visited[a[0]]=(visited[v]+ (1+a[1])%2)%2;
				if(!visit(a[0]))
					return false;
			}else{
				if((visited[a[0]]+visited[v]+ (1+a[1]))%2!=0)
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		long mod = 1000000007L;
		adj=new ArrayList<ArrayList<int[]>>();
		ArrayList<int[]> aux;
		for(int i=0; i<n; i++){
			aux=new ArrayList<int[]>();
			adj.add(aux);
		}
		int a, b, c;
		for(int i=0; i<m; i++){
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken())-1;
			b=Integer.parseInt(st.nextToken())-1;
			c=Integer.parseInt(st.nextToken());
			adj.get(a).add(new int[]{b, c});
			adj.get(b).add(new int[]{a, c});
			
		}
		visited=new int[n];boolean ws=true;
		Arrays.fill(visited, -1);
		for(int i=0; i<n; i++){
			if(visited[i]!=-1)
				continue;
			visited[i]=0;
			cc++;
			if(!visit(i))
				ws=false;
		}
		
		Comparator<int[]> comparator= new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		};
		for(int i=0; i<n; i++){
			Collections.sort(adj.get(i), comparator);
		}
		
//		boolean ws=true;
//		int q;
//		for(int i=0; i<n; i++){
//			for(int[] k: adj.get(i)){
//				for(int[] r: adj.get(k[0])){
//					q=0;
//					int binarySearch = Collections.binarySearch(adj.get(i), r, comparator);
//					if(binarySearch>=0){
//						if(adj.get(i).get(binarySearch)[1]==0)
//							q++;	
//					}else{
//						continue;
//					}
//					if(adj.get(i).get(k[0])[1]==0)
//						q++;
//					if(adj.get(k[0]).get(r[0])[1]==0)
//						q++;
//					if(q%2==1){
//						ws=false;
//						break;
//					}
//					
//				}
//				if(!ws)
//					break;
//			}
//		}
		
		if(ws){
			long ans=1L;
			for(int i=0; i<cc-1; i++){
				ans*=2;
				ans%=mod;
			}
			System.out.println(ans);
		}else{
			System.out.println("0");
		}
		
		
		
		
	}
}
