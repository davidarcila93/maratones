import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Presents_136A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int parent[] = new int[n];
		for(int i=0; i<n; i++){
			parent[ Integer.parseInt(st.nextToken()) - 1 ] = i+1;
		}
		for(int i=0; i<n; i++){
			if(i!=0)
				System.out.print(" ");
			System.out.print(parent[i]);
		}
	}
}
