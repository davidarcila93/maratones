import java.io.*;
import java.util.*;


public class Apples {
	static int[][][] dp;
	static int n,m,k;
	static int ax, ay, at;
	static int[] movx={0,0,0,1,1,1,-1,-1,-1};
	static int[] movy={0,1,-1,0,1,-1,0,1,-1};
	static ArrayList<ArrayList<ArrayList<Integer>>> falltime;
	
	public static int getdp(int x, int y, int t){
		
		if(x<1 || x>n || y<1 || y>m || t>=2*k) return 0;
		if(dp[x][y][t]!=-1)return dp[x][y][t];
		int ans=0;
		for (int i = 0; i < movx.length; i++) {
			ans=Math.max(ans, getdp(x+movx[i], y+movy[i], t+1));
		}
		if(falltime.get(x).get(y).contains(t)) ans++;
		return dp[x][y][t]=ans;
	}
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true){
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			
			if(n==0 && m==0 && k==0)
				break;
			dp=new int[n+1][m+1][2*k+1];
			for (int i = 0; i < n+1; i++) {
				for (int j = 0; j < m+1; j++) {
					Arrays.fill(dp[i][j], -1);
				}
			}
			
			falltime=new ArrayList<ArrayList<ArrayList<Integer>>>();
			
			ArrayList<ArrayList<Integer>> aux;
			ArrayList<Integer> aux1;
			for (int i = 0; i < n+1; i++) {
				aux=new ArrayList<ArrayList<Integer>>();
				for (int j = 0; j < m+1; j++) {
					aux1=new ArrayList<Integer>();
					aux.add(aux1);
				}
				falltime.add(aux);
			}
	
			for (int i = 0; i < k; i++) {
				st=new StringTokenizer(br.readLine());
				ax=Integer.parseInt(st.nextToken());
				ay=Integer.parseInt(st.nextToken());
				at=Integer.parseInt(st.nextToken());
				falltime.get(ax).get(ay).add(at);
			}
			st=new StringTokenizer(br.readLine());
			System.out.println(getdp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));
				
			
			
			
		}
	}

}
