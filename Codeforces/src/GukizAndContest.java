import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class GukizAndContest {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> list, ordered;
		int n=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		list=new ArrayList<Integer>();
		int aux;
		while(st.hasMoreTokens()){
			aux=Integer.parseInt(st.nextToken());
			list.add(aux);
		}
		int total;
		for(int i=0; i<n; i++){
			total=1;
			for(int j=0; j<n; j++){
				if(list.get(j)>list.get(i))
					total++;
			}
			if(i!=0)
				System.out.print(" ");
			System.out.print(total);
		}
	}
}
