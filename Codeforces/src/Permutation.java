import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Permutation {
	static long fib[]=new long[51];
	static int n;
	static long k;
	
	static StringBuilder solve(int index, long count, StringBuilder sb){
//		System.out.println(index+" "+count+" "+sb);
		if(index==n)
			return sb;
		if(index!=0)
			sb.append(" ");
		if(count+fib[n-index-1]<=k)
			return solve(index+2, count+fib[n-index-1], sb.append(index+2).append(" "+(index+1)));
		return solve(index+1, count, sb.append(index+1));
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Long.parseLong(st.nextToken());
		fib[0]=1;
		fib[1]=1;
		for(int i=2; i<51; i++){
			fib[i]=fib[i-1]+fib[i-2];
		}
		
		System.out.println(solve(0, 1, new StringBuilder()));
		
		
	}
}
