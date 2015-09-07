import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class GukizHatesBoxes {
	static ArrayList<Integer> list, acum, remainder;
	static int n,m;
	
	public static boolean can(long k){
		
		return true;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		list = new ArrayList<Integer>(n);
		acum = new ArrayList<Integer>(n);
		remainder = new ArrayList<Integer>(n);
		long min, max, mid;
		min=0; max=1000000000000000000L;
		while(min<max){
			mid=(min+max)/2L;
			if(can(mid)){
				min=mid;
			}else{
				max=mid-1;
			}
		}
	}
}
