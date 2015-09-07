import java.io.BufferedReader;
import java.io.InputStreamReader;


public class DivisibilityBy9 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int n=Integer.parseInt(br.readLine());
		int maxSum, maxSubtract;
		int mod, aux;
		while(n>0){
			n--;
			mod=0;
			str=br.readLine();
			maxSubtract=0; maxSum=0;
			if(str.length()==1){
				int p =Integer.parseInt(str);
				System.out.println(Math.min(p, 9-p));
				continue;
			}
			for(int i=0; i<str.length(); i++){
				aux = Integer.parseInt(str.charAt(i)+"");
				mod = (mod+aux)%9; 
				maxSum += 9-aux;
				if(maxSum>9)
					maxSum=9;
				if(i==0 && aux>1)
					maxSubtract += aux-1;
				else if(i==0)
					;
				else if (i>0)
					maxSubtract += aux;
				if(maxSubtract>9)
					maxSubtract=9;
			}
			int ans=10;
			if(mod<=maxSubtract)
				ans=Math.min(ans, mod);
			if(9-mod<=maxSum)
				ans=Math.min(ans, 9-mod);
			System.out.println(ans);
		}
	}
}
