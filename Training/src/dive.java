import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class dive {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int r, n;
		String str;
		StringBuilder sb;
		boolean returned[];
		while((str=br.readLine().trim())!=null){
			sb=new StringBuilder();
			st=new StringTokenizer(str);
			n=Integer.parseInt(st.nextToken());
			r=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine().trim());
			
			if(n==r)
				sb.append("*");
			else{
				returned=new boolean[n+1];
				
				for (int i = 0; i < r; i++) {
					returned[Integer.parseInt(st.nextToken())]=true;
				}
				for (int i = 1; i <= n; i++) {
					if(!returned[i])
						sb.append(i+" ");
						
				}
				
			}
			System.out.println(sb);
		}

	}
}
