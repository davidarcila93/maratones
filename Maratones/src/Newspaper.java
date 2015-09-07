import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Locale;
import java.util.StringTokenizer;



public class Newspaper {
	public static void main(String[] args)throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k,m,total;
		char c;
		int n=Integer.parseInt(br.readLine());
		int price[];
		double t;
		String ar[];
		for (int i = 0; i < n; i++) {
			total=0;
			price=new int[20005];
			k=Integer.parseInt(br.readLine());
			for (int j = 0; j < k; j++) {
				st=new StringTokenizer(br.readLine());
				c=st.nextToken().charAt(0);
				price[(int)c+10000]=Integer.parseInt(st.nextToken());
			}
			m=Integer.parseInt(br.readLine());
			for (int j = 0; j < m; j++) {
				ar=br.readLine().trim().replaceAll(" ", "").split("");
				for (int u = 0; u < ar.length; u++) {
					if(ar[u].length()>0)
						total+=price[(int)(ar[u].charAt(0))+10000];
				}
				
			}
			t=total/100d;
			DecimalFormat df=new DecimalFormat("0.00$", new DecimalFormatSymbols(Locale.US));
			System.out.println(df.format(t));
			
		}
	}

}
