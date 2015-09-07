import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Swap {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t=Integer.parseInt(br.readLine());
		int n;
		ArrayList<Integer> car;
		int index, ans;
		for (int i = 0; i < t; i++) {
			n=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			car=new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				car.add(Integer.parseInt(st.nextToken()));
			}
			ans=0;
			for (int j = 0; j < n; j++) {
				index=car.indexOf(j+1);
				ans+=index;
				car.remove(index);
				
			}
			System.out.println("Optimal train swapping takes "+ ans +" swaps.");
		}
	}

}
