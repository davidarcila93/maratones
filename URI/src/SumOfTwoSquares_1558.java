import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SumOfTwoSquares_1558 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		String str;
		boolean ws;
		while((str = br.readLine())!=null){
			n = Integer.parseInt(str);
			if(n<0)
				System.out.println("NO");
			else{
				ws = true;
				for(int p = 2; p<=n; p++){
					int power = 0;
					while( n%p ==0 ){
						power++;
						n/=p;
					}
					if( p!=2 && p%4 != 1 && power%2 != 0 )
						ws = false;
				}
				if(ws)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

}
