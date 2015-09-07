import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class lines {
	
	static int L,C;
	static int[][] box;
	static int[] Cper, Lper;
	static boolean[] visited;
	
	public static int cycles(int[] p){
		visited=new boolean[p.length];
		int numcycles=0;
		for (int i = 0; i < p.length; i++) {
			if(visited[i])
				continue;
			numcycles++;
			int act=i;
			while(!visited[act]){
				visited[act]=true;
				act=p[act];
			}
		}
		return numcycles;
	}
	
	public static boolean can(){
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < C; j++) {
				if((box[i][j]/C)!=Cper[i])
					return false;		
				if((box[i][j]%C)!=Lper[j])
					return false;					
			}
		}
		return true;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int aux;
		while((str=br.readLine())!=null){
			st=new StringTokenizer(str);
			L=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			box=new int[L][C];
			Cper=new int[L];
			Lper=new int[C];
			for (int i = 0; i < L; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					aux=Integer.parseInt(st.nextToken())-1;
					box[i][j]=aux;
					if(i==0)
						Lper[j]=aux%C;
					if(j==0)
						Cper[i]=aux/C;
				}
			}
			if(!can())
				System.out.println("*");
			else{
				System.out.println((C+L-cycles(Cper)-cycles(Lper)));
			}
			
			
		}
		
	}
}
