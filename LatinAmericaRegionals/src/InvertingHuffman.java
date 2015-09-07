import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class InvertingHuffman {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Long> prevList, curList;
		long n, lastMax, curMax;
		String str;
		while((str=br.readLine())!=null){
			n=Long.parseLong(str);
			lastMax = 0;
			st=new StringTokenizer(br.readLine());
			long[] v= new long[st.countTokens()];
			int index=0;
			
			while(st.hasMoreTokens()){
				v[index]=Long.parseLong(st.nextToken());
				index++;
			}
			Arrays.sort(v);
			index = v.length-1;
			curList = new ArrayList<Long>();
			lastMax = 0;
			curMax = 0;
			for(int lvl = (int)v[v.length-1]; lvl>=0; lvl--){
//				System.out.println("ENTRA -- "+lvl);
				prevList = (ArrayList<Long>) curList.clone();
				curList = new ArrayList<Long>();
				Collections.sort(prevList);
				lastMax = curMax;
				for(int i=0; i<prevList.size(); i+=2){
//					System.out.println("Recorriendo prevlist");
					long val = prevList.get(i)+prevList.get(i+1);
					curMax = Math.max(curMax, val);
					curList.add(val);
				}
				while(index>=0 && v[index]==lvl){
					if(lvl == v[v.length-1]){
//						System.out.println("*Agrego a nosequien 1");
						curList.add(1L);
						curMax = 1;
					}else{
						curList.add(lastMax);
					}
					index--;
				}
				
			}
			System.out.println(curList.get(0));
		}
	}
}