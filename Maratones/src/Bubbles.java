import java.io.*;
import java.util.*;


public class Bubbles {
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		int p[];
		boolean seen[];
		int cycles;
		int aux;
		while(true){
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			if(n==0)break;
			p=new int[n];
			seen=new boolean[n];
			cycles=0;
			for (int i = 0; i < n; i++) {
				p[i]=Integer.parseInt(st.nextToken())-1;
			}
			for (int i = 0; i < n; i++) {
				aux=i;
				if(!seen[aux])
					cycles++;
				while(!seen[aux]){
					seen[aux]=true;
					aux=p[aux];
				}
			}
			
			if((n-cycles)%2==1)
				System.out.println("Marcelo");
			else
				System.out.println("Carlos");
		}
	}

}
