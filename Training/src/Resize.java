import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Resize {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n,m,a,b;
		StringBuilder sb=new StringBuilder();
		int aux1, aux2;
		String[] ar;
		while(true){
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			ar=new String[n];
			for (int i = 0; i < n; i++) {
				ar[i]=br.readLine();
			}
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			aux1=a/n;
			aux2=b/m;
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
//					System.out.print(ar[i/aux1].charAt(j/aux2));
					sb.append(ar[i/aux1].charAt(j/aux2));
					if(j==b-1)
						sb.append("\n");
//						System.out.println();
				}
			}
			sb.append("\n");
			
		}
		System.out.print(sb);
	}

}
