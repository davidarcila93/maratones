import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class TreeRequest {
	
	static int[] ordered;
	static int[][] powerParent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m, n;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> children = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<n; i++){
			children.add(new ArrayList<Integer>());
		}
		int[] parent = new int[n];
		parent[0]=-1;
		int[] depth = new int[n];
		depth[0] = 1;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n; i++){
			int aux=Integer.parseInt(st.nextToken());
			aux--;
			parent[i]=aux;
			children.get(aux).add(i);
			depth[i]=depth[aux]+1;
		}
		char[] ar = br.readLine().toCharArray();
//		for(int i=0; i<acu.length; i++){
//			System.out.println(Arrays.toString(acu[i]));
//		}
//		
		ordered=new int[n];
		int id=0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		int node;
		while(!q.isEmpty()){
			node=q.poll();
			ordered[id++]=node;
			ArrayList<Integer> list = children.get(node);
			for(int i=0; i<list.size(); i++){
				q.add(list.get(i));
			}
		}
		
		int acu[] = new int[n+1];
		for(int i=1; i<acu.length; i++){
			acu[i]=acu[i-1]^(1<<(ar[ordered[i-1]]-'a'));
		}
		
//		System.out.println(Arrays.toString(ordered));
		
		int log = ((int)Math.log(n+1))+1;
		powerParent= new int[n][log];
		for(int i=0; i<log; i++){
			for(int v=0; v<n; v++){
				if(i==0){
					powerParent[v][i]=parent[v];
				}else{
					if(powerParent[v][i-1]==-1)
						powerParent[v][i]=-1;
					else
						powerParent[v][i]=powerParent[powerParent[v][i-1]][i-1];
				}
			}
		}
		
//		for(int i=0; i<n; i++){
//			System.out.println("POWER");
//			System.out.println(Arrays.toString(powerParent[i]));
//		}
		
		for(int i=0; i<m; i++){
			int v, d;
			st=new StringTokenizer(br.readLine());
			v=Integer.parseInt(st.nextToken());
			v--;
			d=Integer.parseInt(st.nextToken());
			
			int start, end;
			start=-1;
			end=0;
			
			int a, b, mid;
			a=0;
			b=n-1;
			int two = d - depth[ v ] ;
			while(a<b){
				mid=(a+b)/2;
				if( findParent(ordered[mid], two) < v){
					a=mid+1;
				}else{
					b=mid;
				}
			}
			if(findParent(ordered[a], two)==v)
				start=a;
			
			a=0;
			b=n-1;
			while(a<b){
				mid=(a+b+1)/2;
				if( findParent(ordered[mid], two) > v){
					b=mid-1;
				}else{
					a=mid;
				}
			}
			if(findParent(ordered[a], two)==v)
				end=a;
			
//			System.out.println(start+" "+end);
			if(start==-1)
				System.out.println("Yes");
			else{
				if( Integer.bitCount(acu[end+1]^acu[start])>1)
					System.out.println("No");
				else
					System.out.println("Yes");
			}
			
		}
	}
	
	static int findParent( int v, int two){
		int power=0;
		int aux = v;
//		System.out.println("Searching "+v+" "+ordered[a]+" "+two);
		boolean ws=true;
		while(two>0 && ws){
//			System.out.println(aux);
			if(two%2==1)
				aux=powerParent[aux][power];
			two/=2;
			power++;
			if(aux==-1)
				ws=false;
		}
		return aux;
	}
}
