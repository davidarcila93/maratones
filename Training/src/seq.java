import java.io.BufferedReader;
import java.io.InputStreamReader;


public class seq {

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int min=0;
		int sum=0;
		int len=0;
		int last;
		int n;
		int cursum=0;
		String str;
		n=Integer.parseInt(br.readLine());
		sum=n;
		cursum=n;
		len=1;
		min=1;
		while(!(str=br.readLine()).contentEquals("")){
			last=n;
			n=Integer.parseInt(str);
			if(n>last){
				cursum+=n;
				len++;
				if(len>min){
					min=len;
					sum=cursum;
				}
			}
			else{
				cursum=n;
				len=1;
			}
			
			
		}
		System.out.println(sum);
		
	}

}
