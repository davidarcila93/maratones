import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ZgukistringZ {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a, b, c;
		a=br.readLine();
		b=br.readLine();
		c=br.readLine();
		int[][] letters = new int[3][26];
		for(int i=0; i<a.length(); i++){
			letters[0][a.charAt(i)-'a']++;
		}
		for(int i=0; i<b.length(); i++){
			letters[1][b.charAt(i)-'a']++;
		}
		for(int i=0; i<c.length(); i++){
			letters[2][c.charAt(i)-'a']++;
		}
		int maxB=Integer.MAX_VALUE;
//		int maxC=0;
		for(int i=0; i<26; i++){
			if(letters[1][i]>0)
				maxB= Math.min(maxB, letters[0][i]/letters[1][i]);
//			maxC= Math.max(maxC, letters[0][i]/letters[2][i]);
		}
		int ansB=0, ansC=0;
		int aux;
		for(int i=0; i<=maxB; i++){
			aux=Integer.MAX_VALUE;
			for(int j=0; j<26; j++){
				if(letters[2][j]>0)
					aux=Math.min(aux, (letters[0][j]-i*letters[1][j])/letters[2][j]);
			}
			if(i+aux>ansB+ansC){
				ansB=i;
				ansC=aux;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<ansB; i++){
			sb.append(b);
		}
		for(int i=0; i<ansC; i++){
			sb.append(c);
		}
		for(int i=0; i<26;i++){
			letters[0][i]=letters[0][i]-ansB*letters[1][i]-ansC*letters[2][i];
			for(int j=0; j<letters[0][i]; j++){
				sb.append((char)(i+'a'));
			}
		}
		System.out.println(sb);
	}
}
