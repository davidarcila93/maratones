import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class PrimesOrPalindromes {
	public static void main(String[] args)throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p,q;
		p=Integer.parseInt(st.nextToken());
		q=Integer.parseInt(st.nextToken());
		boolean criba[] = new boolean[1179858+1000];
		boolean palindrome[] = new boolean[1179858+1000];
		Arrays.fill(criba, true);
		Arrays.fill(palindrome, false);
		criba[0]=false;
		criba[1]=false;
		for(int i=2; i<criba.length; i++){
			if(!criba[i])
				continue;
			if(i>10000)
				continue;
			int aux = i*i;
			while(aux<criba.length){
				criba[aux]=false;
				aux+=i;
			}
		}
		for(int i=1; i<palindrome.length; i++){
			if(isPalindrome(i))
				palindrome[i]=true;
		}
		int ans=-1;
		int pi=0;
		int rub=0;
		for(int i=1; i<criba.length; i++){
			if(criba[i])
				pi++;
			if(palindrome[i])
				rub++;
			if(pi*q<=p*rub){
//				System.out.println(pi+" "+rub);
				ans=Math.max(ans, i);
			}
		}
		if(ans == criba.length-1 || ans==-1)
			System.out.println("Palindromic tree is better than splay tree");
		else
			System.out.println(ans);
			
		
		
		
	}
	
	static boolean isPalindrome(int n){
		String s= ""+n;
		for(int i=0; i<s.length()/2; i++){
			if(s.charAt(i)!=s.charAt(s.length()-i-1))
				return false;
		}
		return true;
	}
}
