import java.io.BufferedReader;
import java.io.FileReader;


public class EquivalentStrings {
	public static void main(String[] args)throws Exception {
		/*Random random=new Random();
		System.setOut(new PrintStream("EquivalentStrings.in"));
		for(int i=0;i<1<<17;i++)
			System.out.print((char)('a'+random.nextInt(26)+1));
		System.out.println();
		for(int i=0;i<1<<17;i++)
			System.out.print((char)('a'+random.nextInt(26)+1));
		System.out.println();*/
		
		BufferedReader br = new BufferedReader(new FileReader("EquivalentStrings.in"));
		String a, b;
		a=br.readLine();
		b=br.readLine();
		if(areEqual(a, b))
			System.out.println("YES");
		else 
			System.out.println("NO");
	}
	
	public static boolean areEqual(String a, String b){
		if(a.equals(b))
			return true;
		if(a.length()==b.length() && a.length()%2==0){
			String aa, ab, ba, bb;
			aa=a.substring(0, a.length()/2);
			ab=a.substring(a.length()/2);
			ba=b.substring(0, b.length()/2);
			bb=b.substring(b.length()/2);
			if(areEqual(aa, ba) && areEqual(ab, bb))
				return true;
			if(areEqual(aa, bb) && areEqual(ab, ba))
				return true;
		}
		return false;
	}
}
