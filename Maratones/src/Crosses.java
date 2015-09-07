import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Crosses {
	static int n;
	static boolean[][] board;
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		board=new boolean[n][n];
		String str;
		boolean can=true;
		for (int i = 0; i < n; i++) {
			str=br.readLine().trim();
			for (int j = 0; j < n; j++) {
				if(str.charAt(j)=='.')
					board[i][j]=true;
				else
					board[i][j]=false;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!board[i][j]){
					if(j==0 || j==n-1 || i==n-2 || i==n-1){
						can=false;
						break;
					}
					board[i][j]=true;
					if(board[i+1][j-1] || board[i+1][j] || board[i+1][j+1] || board[i+2][j]){
						can=false;
						break;
					}
					board[i+1][j-1]=true;
					board[i+1][j]=true;
					board[i+1][j+1]=true;
					board[i+2][j]=true;
					
						
				}
					
			}
			if(!can)
				break;
		}
		if(can)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}

}
