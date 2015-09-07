import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class InvertingHuffman {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> prevList, curList;
		int n, lastMax;
		String str;
		while((str=br.readLine())!=null){
			n=Integer.parseInt(str);
			lastMax = 0;
			st=new StringTokenizer(br.readLine());
			int[] v= new int[st.countTokens()];
			int index=0;
			
			while(st.hasMoreTokens()){
				v[index]=Integer.parseInt(st.nextToken());
				index++;
			}
			Arrays.sort(v);
			index = v[v.length-1];
			curList = new ArrayList<Integer>();
			for(int lvl = v[v.length-1]; lvl>0; lvl--){
				prevList = (ArrayList<Integer>) curList.clone();
				curList = new ArrayList<Integer>();
				
			}
		}
	}
}
