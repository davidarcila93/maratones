import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class GuessThatCar_201B {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[][] rarity = new long[n][m];
		long xacu=0L, yacu=0L, tot=0L;
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				rarity[i][j] = Long.parseLong(st.nextToken());
				tot+=rarity[i][j];
				xacu+= rarity[i][j]*(4*i+2);
				yacu+= rarity[i][j]*(4*j+2);
			}
		}
		if(tot==0){
			System.out.println("0");
			System.out.println("0 0");
			return;
		}
			
//		System.out.println("** "+xacu/(double)tot+" "+yacu/(double)tot);
		int x = (int)Math.floor((xacu/tot)/4.);
		int y = (int)Math.floor((yacu/tot)/4.);
		
		int ansx = 0;
		int ansy = 0;
		long val = 1000000000000000000L;
		long aux;
		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				aux = 0L;	
				for(int a=0; a<n; a++){
					for(int b=0; b<m; b++){
						aux += rarity[a][b]*( (4*(x+i) - (4*a+2) )*(4*(x+i) - (4*a+2) ) +  (4*(y+j) - (4*b+2) )*(4*(y+j) - (4*b+2) ));
					}
				}
				if(aux < val){
					val=aux;
					ansx = x+i; 
					ansy = y+j;
//					System.out.println("..... "+val+" "+ansx+" "+ansy);
				}
				
			}
		}
		System.out.println(val);
		System.out.println(ansx+" "+ansy);
		
	}

}
