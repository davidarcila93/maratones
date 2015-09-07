import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Magnets_344A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str="", aux;
		int count = 0;
		for(int i = 0; i<n; i++){
			aux = br.readLine();
			if( !str.equals(aux) )
				count++;
			str = aux;
		}
		System.out.println(count);
	}
}
