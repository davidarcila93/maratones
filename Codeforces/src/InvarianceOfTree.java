import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class InvarianceOfTree {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		boolean one = false;
		int idOne = -1;
		boolean two = false;
		int idTwoA = -1;
		int idTwoB = -1;
		boolean notEven = false;
		int p[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			p[i] = Integer.parseInt(st.nextToken())-1;
		}
		boolean visited[] = new boolean[n];
		int size;
		for(int i=0; i<n; i++){
			if( p[i] == i ){
				one = true;
				idOne = i;
			}
			else if(p[ p[i] ] == i){
				two = true;
				idTwoA = i;
				idTwoB = p[i];
			}
		}
		if(one){
			System.out.println("YES");
			for(int i=0; i<n; i++){
				if( i == idOne)
					continue;
				System.out.println( (i+1)+" "+(idOne+1) );
			}
		}else if(two){
			int aux = 0;
			x.add(idTwoA);
			y.add(idTwoB);
			for(int i=0; i<n; i++){
				if(i==idTwoA || i== idTwoB)
					continue;
				if(visited[i])
					continue;
				int k = i;
				while(!visited[k]){
					visited[k]=true;
					if(aux == 0){
						x.add(idTwoA);
						y.add(k);
					}
					else{
						x.add(idTwoB);
						y.add(k);
					}
					aux = 1-aux;
					k = p[k];
				}
				if(aux == 1)
					notEven = true;
			}
			if(notEven)
				System.out.println("NO");
			else{
				System.out.println("YES");
				for(int i=0; i<x.size(); i++){
					System.out.println( (x.get(i)+1) + " " + (y.get(i)+1));
				}
			}
		}else
			System.out.println("NO");
	}
}
