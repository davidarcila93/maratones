import java.io.*;
import java.util.*;



public class LargestSum {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int max;
		int cur;
		int aux;
		while((str=br.readLine())!=null){
			st=new StringTokenizer(str);
			max=0;
			cur=0;
			while(st.hasMoreTokens()){
				cur=cur+Integer.parseInt(st.nextToken());
				if(cur<0)
					cur=0;
				else
					max=Math.max(max, cur);
				
			}
			System.out.println(max);
		}
	}

}
