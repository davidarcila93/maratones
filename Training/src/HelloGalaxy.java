import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class HelloGalaxy {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n, minyear, actyear;
		String first, act;
		first="";
		while((n=Integer.parseInt(br.readLine()))!=0){
			minyear=1000000000;
			for (int i = 0; i < n; i++) {
				st=new StringTokenizer(br.readLine());
				act=st.nextToken();
				actyear=Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken());
				if(actyear<minyear){
					minyear=actyear;
					first=act;
				}
					
			}
			System.out.println(first);
		}
	}

}
