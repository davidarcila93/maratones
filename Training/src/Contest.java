import java.io.*;
import java.util.*;

public class Contest {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int c, p;
		int[] cSol, pSol;
		int ans;
		boolean can1,can2,can3,can4;
		while(true){
			st=new StringTokenizer(br.readLine());
			c=Integer.parseInt(st.nextToken());
			p=Integer.parseInt(st.nextToken());
			if(c==0 && p==0)
				break;
			cSol=new int[c];
			pSol=new int[p];
			for (int i = 0; i < c; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < p; j++) {
					if(st.nextToken().contentEquals("1")){
						cSol[i]++;
						pSol[j]++;
					}
				}
			}
			can1=true;
			can2=true;
			can3=true;
			can4=true;
			
			for (int i = 0; i < pSol.length; i++) {
				if(pSol[i]==0)
					can1=false;
				if(pSol[i]==c)
					can2=false;
			}
			for (int i = 0; i < cSol.length; i++) {
				if(cSol[i]==0)
					can3=false;
				if(cSol[i]==p)
					can4=false;
			}
			
			ans=0;
			if(can1)
				ans++;
			if(can2)
				ans++;
			if(can3)
				ans++;
			if(can4)
				ans++;
			System.out.println(ans);
		}
	}

}
