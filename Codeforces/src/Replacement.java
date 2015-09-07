import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Replacement {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m, n;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		String str = br.readLine();
		char ar[] = str.toCharArray();
		int steps=0;
		for(int i=1; i<n; i++){
			if(ar[i]=='.' && ar[i-1]=='.')
				steps++;
		}
		int pos;
		char c;
		for(int i=0; i<m; i++){
			st=new StringTokenizer(br.readLine());
			pos=Integer.parseInt(st.nextToken());
			pos--;
			c=st.nextToken().charAt(0);
			if(ar[pos]=='.' && c!='.'){
				if(pos>0 && ar[pos-1]=='.')
					steps--;
				if(pos<n-1 && ar[pos+1]=='.')
					steps--;
			}else if(ar[pos]!='.' && c=='.'){
				if(pos>0  && ar[pos-1]=='.')
					steps++;
				if(pos<n-1 && ar[pos+1]=='.')
					steps++;
			}
			ar[pos]=c;
			System.out.println(steps);
		}
	}
}
