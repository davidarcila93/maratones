import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BloggerLanguage {
	
	static int size;
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		String aux, search;
		while((aux=br.readLine())!=null){
			st=new StringTokenizer(aux);
			n=Integer.parseInt(st.nextToken());
			search=st.nextToken();
			
			
		}
	}
	
	static class SegTree{
		int start, end;
		int max, min;
		SegTree left, right;
		boolean propagate;
		SegTree(int start, int end){
			this.start = start;
			this.end = end;
			if(start==end)
				return;
			int mid = (start+end)/2;
			propagate = true;
			left = new SegTree(start, mid);
			right = new SegTree(mid+1, end);
		}
		
	}
	
}
