import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ClearSymmetry_201A {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 2){
			System.out.println("3");
			return;
		}
		if(n==3){
			System.out.println("5");
			return;
		}
		for(int i= 1; i<100; i++){
			if(n%4==0 && i%2==0 && ((i-2)*(i-2))/2>=n ){
				System.out.println(i);
				return;
			}
//			System.out.println(i-1);
//			System.out.println((i-1)/2);
//			System.out.println(((((i-1)/2)*i)+1)/2*2);
			if(i%2==1 && (i*i+1)/2>=n ){
				System.out.println(i);
				return;
			}
				
		}
	}

}
