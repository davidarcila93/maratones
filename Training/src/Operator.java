import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Operator {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int start[],end[];
		int N,M;
		int a,b,ans;
		
		while(true){
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			if(N==0 && M==0)
				break;

			start=new int[N];
			end=new int[N];
			
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine());
				st.nextToken();
				st.nextToken();
				start[i]=Integer.parseInt(st.nextToken());
				end[i]=Integer.parseInt(st.nextToken())+start[i];
			}
			for (int i = 0; i < M; i++) {
				st=new StringTokenizer(br.readLine());
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken())+a;
				ans=0;
				for (int j = 0; j < N; j++) {
					if(start[j]<b && end[j]>a)
						ans++;
				}
				System.out.println(ans);
			}
		}
		
		
	}

}
