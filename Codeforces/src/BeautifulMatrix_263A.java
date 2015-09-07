import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BeautifulMatrix_263A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 0, y = 0;
		String[] s;
		for(int i=0; i<5; i++){
			s = br.readLine().split(" ");
			for(int j=0; j<5; j++){
				if(s[j].equals("1")){
					x=i;
					y=j;
				}
			}
		}
		System.out.println( (Math.abs(2-x) + Math.abs(2-y)) );
	}
}
