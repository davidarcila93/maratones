import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class IngeniousMetro {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t, q;
		int s, e;
		int tele[];
		while(true){
			st=new StringTokenizer(br.readLine());
			t=Integer.parseInt(st.nextToken());
			q=Integer.parseInt(st.nextToken());
			if(t==0 && q==0)
				return;
			tele=new int[t];
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<t; i++){
				tele[i]=Integer.parseInt(st.nextToken());
			}
			int gcd=0;
			for(int i=1; i<tele.length; i++){
				gcd=gcd(gcd, 2*Math.abs(tele[i]-tele[i-1]));
			}
			for(int i=0; i<q; i++){
				if(i!=0)
					System.out.print(" ");
				st=new StringTokenizer(br.readLine());
				s=Integer.parseInt(st.nextToken());
				e=Integer.parseInt(st.nextToken());
				if(t==1){
					if(s==e || 2*tele[0]-s==e)
						System.out.print("Y");
					else
						System.out.print("N");
				}else{
					boolean ws=false;
					if( Math.abs(e-s)%gcd==0 )
						ws=true;
					for(int j=0; j<t; j++){
						if( Math.abs(e- (2*tele[j]-s) )%gcd==0)
							ws=true;
					}
					if(ws)
						System.out.print("Y");
					else
						System.out.print("N");
				}
			}
			System.out.println();
		}
	}
	
	static int gcd(int a, int b){
		if (a<0)
			a*=-1;
		if (b<0)
			b*=-1;
		if(b==0)
			return a;
		return gcd(b, a%b);
	}

}
