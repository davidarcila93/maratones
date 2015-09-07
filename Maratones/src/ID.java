import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class ID {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list,actlist;
		String str;
		int k,size,cur,aux,actsize;
		while(!(str=br.readLine()).contentEquals("#")){
			list=new ArrayList<Integer>();
			actlist=new ArrayList<Integer>();
			size=str.length();
			for (int i = 0; i < size; i++) {
				list.add((int)str.charAt(i));
			}
			k=-1;
			actlist.add(list.get(size-1));
			actsize=0;
			list.remove(size-1);
			
			for (int i = size-2; i >=0; i--) {
				cur=list.get(i);
				actlist.add(cur);
				
				list.remove(i);
				actsize++;
				if(cur<actlist.get(actsize-1)){
					k=i;
					
					break;
				}
			}
			if(k==-1)
				System.out.println("No Successor");
			else{
				cur=actlist.get(actlist.size()-1);
				
				for (int i = 0; i < actlist.size(); i++) {
					if(cur<actlist.get(i)){
						aux=actlist.get(i);
						actlist.remove(i);
						
						Collections.sort(actlist);
						list.add(aux);
						for (int j = 0; j < actlist.size(); j++) {
							list.add(actlist.get(j));
						}
						break;
					}
					
				}
				for (int i = 0; i < list.size(); i++) {
					System.out.print(Character.toChars(list.get(i)));
					if(i==list.size()-1)
						System.out.println();
				}
			}
			
			
		}
	}

}
