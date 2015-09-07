import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Parentheses {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		int n=Integer.parseInt(br.readLine());
		Stack<Character> s;
		boolean can;
		for (int i = 0; i < n; i++) {
			str=br.readLine();
			s=new Stack<Character>();
			can=true;
			for (int j = 0; j < str.length(); j++) {
				if((str.charAt(j)==')' || str.charAt(j)==']')&& s.isEmpty()){
					can=false;
					break;
				}
				else if((str.charAt(j)==')' && s.peek()!='(') || (str.charAt(j)==']' && s.peek()!='[') ){
					can=false;
					break;
				}else if(str.charAt(j)==')' || str.charAt(j)==']' ){
					s.pop();
				}
				else
					s.push(str.charAt(j));
			}
			if(s.isEmpty() && can)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

}
