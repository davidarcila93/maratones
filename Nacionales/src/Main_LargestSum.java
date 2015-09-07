import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.rmi.CORBA.Util;


public class Main_LargestSum {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int max, acu, aux;
		while((str=br.readLine())!=null){
			max=0;
			acu=0;
			st=new StringTokenizer(str);
			while(st.hasMoreTokens()){
				aux=Integer.parseInt(st.nextToken());
				if(acu+aux>0){
					acu+=aux;
					max=Math.max(max, acu);
				}
				else{
					acu=0;
				}
			}
			System.out.println(max);
		}
	}
}
