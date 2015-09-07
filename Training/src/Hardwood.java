import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class Hardwood {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(br.readLine());
		TreeMap<String, Integer> trees;
		br.readLine();
		String str;
		double ans;
		int total;
		boolean first=true;
		while((str=br.readLine())!=null){
			trees=new TreeMap<String, Integer>();
			trees.put(str, 1);
			total=1;
			if(!first)
				System.out.println();
			else
				first=false;
			while( (str=br.readLine())!=null && !(str).contentEquals("")){
				total++;
				if(trees.containsKey(str))
					trees.put(str, trees.get(str)+1);
				else
					trees.put(str, 1);
			}
			
			for(String s: trees.keySet()){
				ans=trees.get(s)/(double)total*100;
				System.out.printf("%s %.4f\n",s,ans);
			}
		}
	}

}
