import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FlowersFlourishFromFrance {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str, aux;
		char c;
		while(!(str=br.readLine()).equals("*")){
			str=str.toLowerCase();
			st = new StringTokenizer(str);
			boolean ws=true;
			aux=st.nextToken();
			c=aux.charAt(0);
			while(st.hasMoreTokens()){
				aux=st.nextToken();
				if(c!=aux.charAt(0)){
					ws=false;
//					System.out.println(c+" "+aux.charAt(0));
				}
			}
//			System.out.println(ws);
			if(ws)
				System.out.println("Y");
			else
				System.out.println("N");
		}
	}

}
