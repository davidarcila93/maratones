import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CutTheSilverBar {

	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(br.readLine());
			if(n==0)
				return;
			int power, two;
			power=0;
			two=1;
			while(two-1<n){
				power++;
				two*=2;
			}
			power--;
			System.out.println(power);
		}
	}

}
