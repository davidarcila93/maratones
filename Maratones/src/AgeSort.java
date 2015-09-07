import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class AgeSort {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ages[];
		int n;
		StringBuilder sb=new StringBuilder();
		while(true){
			n=Integer.parseInt(br.readLine());
			if(n==0)break;
			st=new StringTokenizer(br.readLine());
			ages=new int[n];
			for (int i = 0; i < n; i++) {
				ages[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(ages);
			
			for (int i = 0; i < n; i++) {
				sb.append(ages[i]);
				if(i<n-1)
					sb.append(" ");
				if(i==n-1)
					sb.append("\n");
			}
			
					
		}
		System.out.print(sb);
	}

}
