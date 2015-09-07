import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ChefAndMemoryLimit_CBARG {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T, n;
		long aux;
		T = Integer.parseInt(br.readLine());
		long last;
		long total;
		for(int i=0; i<T; i++){
			n = Integer.parseInt(br.readLine());
			last=0;
			total=0;
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				aux = Long.parseLong(st.nextToken());
				if(aux>last)
					total+=aux-last;
				last=aux;
			}
			System.out.println(total);
		}
	}
}
