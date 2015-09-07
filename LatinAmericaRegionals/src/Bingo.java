import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Bingo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n, b;
		boolean can[];
		int list[];
		while(true){
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			if(n==0 && b==0)
				return;
			can=new boolean[n+1];
			list = new int[b];
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<b; i++){
				list[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<b; i++){
				for(int j=i; j<b; j++){
					can[Math.abs(list[i]-list[j])] = true;
				}
			}
			boolean ws=true;
			for(int i=0; i<can.length; i++){
				if(!can[i])
					ws=false;
			}
			if(ws)
				System.out.println("Y");
			else
				System.out.println("N");
		}
	}

}
