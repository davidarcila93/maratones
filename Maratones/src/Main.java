
import java.math.BigInteger;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		int squares[]={0,1};
		boolean flag=true;
		boolean values[]=new boolean[4];
		BigInteger Biga;
		BigInteger Bigb;
		for (int a = 1; a < 4; a++) {
			for (int b = a; b <4; b++) {
//				Biga=new BigInteger(""+a);
//				Bigb=new BigInteger(""+b);
//				if(!Biga.gcd(Bigb).equals(BigInteger.ONE))
//					continue;
//				
				flag=true;
				Arrays.fill(values, false);
				for (int x = 0; x < squares.length; x++) {
					for (int y = 0; y < squares.length; y++) {
						values[(a*squares[x]+b*squares[y])%4]=true;
					}
				}
				for (int i = 0; i < values.length; i++) {
					if(!values[i]){
						flag=false;
						System.out.println("Para a="+a+", b="+b+" no se obtiene "+i);
					}
						
				}
				if(flag)
					System.out.println("Para a="+a+", b="+b+" puede ser universal");
			}
		}
		
		
	}
}

