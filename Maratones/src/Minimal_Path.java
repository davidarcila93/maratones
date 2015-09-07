import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Minimal_Path {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(br.readLine());
		int max=1002;
		boolean adj[][]=new boolean[max][max];
		int n=2;
		int lo=0;
		int hi=1;
		int d=2;
		int sq;
		while(k%d==0){
			k=k/d;
			n+=d;
			for (int i = hi; i < hi+d; i++) {
				for (int j = lo; j < hi; j++) {
					adj[i][j]=true;
					adj[j][i]=true;
				}
			}
			
			lo=hi;
			hi=hi+d;
		}
		d=3;
		sq=(int)Math.sqrt(k+2);
		while( d<=sq){
			while(k%d==0){
				k=k/d;
				sq=(int)Math.sqrt(k+2);
				n+=d;
				for (int i = hi; i < hi+d; i++) {
					for (int j = lo; j < hi; j++) {
						adj[i][j]=true;
						adj[j][i]=true;
					}
				}
				
				lo=hi;
				hi=hi+d;
				
				
			}
			d=d+2;
			
		}
		if(k!=1){
			d=k;
			n+=d;
			for (int i = hi; i < hi+d; i++) {
				for (int j = lo; j < hi; j++) {
					adj[i][j]=true;
					adj[j][i]=true;
				}
			}
			
			lo=hi;
			hi=hi+d;
			
		}
		for (int i = lo; i < hi; i++) {
			adj[i][n-1]=true;
			adj[n-1][i]=true;
		}
		int[] ar=new int[n];
		
		ar[0]=0;
		ar[1]=n-1;
		for (int i = 2; i < n; i++) {
			ar[i]=i-1;
		}
		StringBuilder sb=new StringBuilder();
		sb.append(n+"\n");
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				if(adj[ar[i]][ar[j]])sb.append("Y");
//				if(adj[ar[i]][ar[j]])System.out.print("Y");
				else sb.append("N");
//				else System.out.print("N");
				if(j==n-1)
					sb.append("\n");
//					System.out.println();
			}
		}
		System.out.println(sb);
		
	}

}
