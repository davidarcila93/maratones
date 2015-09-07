import java.io.InputStreamReader;

import java.io.BufferedReader;


public class DoubleCola_82A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		String s[] = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
		long cur = 0;
		long two = 1;
		while( cur >= 0 ){
			for(int i=0; i<5; i++){
				cur += two;
				if(cur >= n){
					System.out.println(s[i]);
					return;
				}
			}
			two *= 2;
		}
	}
}
