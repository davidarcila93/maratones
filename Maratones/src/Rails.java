import java.io.*;
import java.util.*;


public class Rails {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> in;
		Stack<Integer> station;
		Stack<Integer> out;
		int n;
		String str;
		
		while(true){
			n=Integer.parseInt(br.readLine().trim());
			if(n==0)break;
			while(true){
				if((str	=br.readLine().trim()).contentEquals("0")){
					System.out.println();
					break;
				}
				in=new Stack<Integer>();
				station=new Stack<Integer>();
				out=new Stack<Integer>();
				for (int i = n; i >= 1; i--) {
					in.push(i);
				}
				st=new StringTokenizer(str);
				for (int i = 0; i < n; i++) {
					station.push(Integer.parseInt(st.nextToken()));
				}
				for (int i = 0; i < n; i++) {
					out.push(station.pop());
				}
				
				while(!in.isEmpty()){
					if(in.peek()==out.peek()){
						out.pop();
						in.pop();
						while(!station.isEmpty() && station.peek()==out.peek()){
							station.pop();
							out.pop();
						}
							
					}
					else
						station.push(in.pop());
				}
				if(out.isEmpty())
					System.out.println("Yes");
				else
					System.out.println("No");
				
			}
			
			
		}
	}

}
