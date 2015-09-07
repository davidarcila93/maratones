import java.io.BufferedReader;
import java.io.InputStreamReader;


public class VanyaAndCubes_492A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int acu = 0;
		int lvl = 0;
		while(acu <= n){
			lvl++;
			acu+=(lvl*(lvl+1))/2;
		}
		System.out.println(lvl-1);
	}
}
