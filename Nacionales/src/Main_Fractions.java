import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main_Fractions {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		BigInteger n, d;
		ArrayList<String> coef;
		StringBuilder sb;
		int[] sizes;
		int caso=1;
		while(!(str=br.readLine().trim()).contentEquals("0 0")){
			st=new StringTokenizer(str);
			n=new BigInteger(st.nextToken());
			d=new BigInteger(st.nextToken());
			sb=new StringBuilder();
			sb.append("Case "+caso+":\n");
			caso++;
			sb.append(n+" / "+d+"\n");
			coef=solve(n,d);
			
			sizes=new int[coef.size()];
			int total=0;
			for (int i = coef.size()-2; i >=0; i--) {
				total+=coef.get(i+1).length();
				sizes[i]=total;
			}
			int acum=0;
			for (int i = 0; i < coef.size()-1; i++) {
				for (int j = 0; j < coef.get(i).length()+acum; j++) {
//					System.out.print(".");
					sb.append(".");
				}
				for (int j = 0; j < sizes[i]; j++) {
					if(j==(sizes[i]-1)/2)
//						System.out.print("1");
						sb.append("1");
					else
//						System.out.print(".");
						sb.append(".");
				}
				sb.append("\n");
				
				for (int j = 0; j < acum; j++) {
//					System.out.print(".");
					sb.append(".");
				}
//				System.out.print(coef.get(i));
				sb.append(coef.get(i));
				for (int j = 0; j < sizes[i]; j++) {
//					System.out.print("-");
					sb.append("-");
				}
//				System.out.println();
				sb.append("\n");
				
				acum+=coef.get(i).length();
						
			}
			for (int i = 0; i < coef.get(0).length()+sizes[0]-1; i++) {
//				System.out.print(".");
				sb.append(".");
			}
//			System.out.println("1");
			sb.append("1");
			System.out.println(sb);
			
		}
		
	}

	private static ArrayList<String> solve(BigInteger n, BigInteger d) {
		ArrayList<String> ans=new ArrayList<String>();
		BigInteger aux;
		while(!n.mod(d).equals(BigInteger.ZERO)){
			ans.add(""+n.divide(d)+".+.");
			aux=n;
			n=d;
			d=aux.subtract(aux.divide(d).multiply(d));			
		}
		if(n.divide(d).equals(BigInteger.ONE))
			ans.add("1");
		else{
			ans.add(""+n.divide(d).subtract(BigInteger.ONE)+".+.");
			ans.add("1");
		}
		return ans;
	}
}
