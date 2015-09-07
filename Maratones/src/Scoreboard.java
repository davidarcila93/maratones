import java.io.*;
import java.util.*;



public class Scoreboard {
	
	public static class Contestant implements Comparable<Contestant>{
		int n;
		int solved;
		int time;
		
		public Contestant(int n, int solved, int time) {
			this.n = n;
			this.solved = solved;
			this.time = time;
		}

		public int compareTo(Contestant o) {
			if(this.solved != o.solved) return o.solved-this.solved;
			if(this.time != o.time) return this.time-o.time;
			if(this.n != o.n) return this.n-o.n;
			return 0;
		}
		
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t=Integer.parseInt(br.readLine());
		String str;
		int wa[][];
		boolean participation[];
		int total[];
		int solved[];
		int n,p,time;
		char c;
		ArrayList<Contestant> con;
		for (int i = 0; i < t; i++) {
			if(i==0)br.readLine();
			wa=new int[101][10];
			participation=new boolean[101];
			total=new int[101];
			solved=new int[101];
			while((str=br.readLine())!=null && !str.contentEquals("")){
				st=new StringTokenizer(str);
				n=Integer.parseInt(st.nextToken());
				p=Integer.parseInt(st.nextToken());
				time=Integer.parseInt(st.nextToken());
				c=st.nextToken().charAt(0);
				participation[n]=true;
				if(c=='I'){
					if(wa[n][p]!=-1)
						wa[n][p]+=1;
					
				}
				else if(c=='C'){
					if(wa[n][p]!=-1){
						total[n]+=time+20*wa[n][p];
						wa[n][p]=-1;
						solved[n]++;
						
					}
					
				}	
			}
			con=new ArrayList<Contestant>();
			for (int j = 0; j < 101; j++) {
				if(participation[j])
					con.add(new Contestant(j, solved[j], total[j]));
			}	
			Collections.sort(con);
			
			for (int j = 0; j < con.size(); j++) {
				System.out.println(con.get(j).n+" "+con.get(j).solved+" "+con.get(j).time);
				if(j==con.size()-1 && i!=t-1)
					System.out.println();
			}
			
			
		}
	}

}
