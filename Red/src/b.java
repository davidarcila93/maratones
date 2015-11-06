import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b {
	
	static int L, K;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long min = 1;
		long max = 1000000000000L;
		long mid = 0;
		while( min != max ){
			mid = (min+max+1L)/2L;
			if( can(mid) ){
				min = mid;
			}else{
				max = mid-1L;
			}
		}
		System.out.println(min);
	}
	
	public static boolean can( long min ){
		int count = 0;
		long cur = 0;
		for(int i=0; i<L; i++){
			cur+= 2*i+1;
			if( cur>=min ){
				count++;
				cur=0;
			}
			if(count==K)
				return true;
		}
		return false;
	}

}
