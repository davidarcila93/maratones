import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Endians {
	
	public static String reverse(String str){
		String ans="";
		for (int i = 0; i < str.length(); i++) {
			ans=str.charAt(i)+ans;
		}
		
		return ans;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		long n;
		String s1,s2,s3,s4;
		while((str=br.readLine())!=null){
			n=Long.parseLong(str);
			str=Long.toString(n, 2);
			while(str.length()<31){
				str="0"+str;
			}
//			s1=str.substring(0,8);
//			s2=str.substring(8,16);
//			s3=str.substring(16,24);
//			s4=str.substring(24,32);
//			s1=reverse(s1);
//			s2=reverse(s2);
//			s3=reverse(s3);
//			s4=reverse(s4);
//			str=s1+s2+s3+s4;
			str=reverse(str);
			System.out.println(Long.parseLong(str, 2));
		}
	}

}
