import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class ElectricalPollution {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int m, q;
		int tmp;
		TreeMap<Integer, ArrayList<Pair>> adj;
		TreeMap<Integer, Integer> xId, yId;
		TreeMap<Integer, Integer> xFromId, yFromId;
		TreeMap<Integer, Integer> values;
		TreeSet<Integer> used;
		int x, y, measure;
		Queue<Integer> Q;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		q=Integer.parseInt(st.nextToken());
		while(m+q!=0){
			adj=new TreeMap<Integer, ArrayList<Pair>>();
			xId=new TreeMap<Integer, Integer>();
			yId=new TreeMap<Integer, Integer>();
			xFromId=new TreeMap<Integer, Integer>();
			yFromId=new TreeMap<Integer, Integer>();
			values=new TreeMap<Integer, Integer>();
			tmp=0;
			for(int i=0; i<m; i++){
				st=new StringTokenizer(br.readLine());
				x=Integer.parseInt(st.nextToken());
				y=Integer.parseInt(st.nextToken());
				measure=Integer.parseInt(st.nextToken());
				if(!xId.containsKey(x)){
					xId.put(x, tmp);
					xFromId.put(tmp, x);
					adj.put(tmp++, new ArrayList<Pair>());
				}
				if(!yId.containsKey(x)){
					yId.put(x, tmp);
					yFromId.put(tmp, x);
					adj.put(tmp++, new ArrayList<Pair>());
				}
				if(!yId.containsKey(y)){
					yId.put(y, tmp);
					yFromId.put(tmp, y);
					adj.put(tmp++, new ArrayList<Pair>());
				}
				if(!xId.containsKey(y)){
					xId.put(y, tmp);
					xFromId.put(tmp, y);
					adj.put(tmp++, new ArrayList<Pair>());
				}
				if(x==y){
					values.put(xId.get(x), measure/2);
					values.put(yId.get(y), measure/2);
				}else{
					adj.get( xId.get(x) ).add(new Pair( yId.get(y) , measure));
					adj.get( yId.get(x) ).add(new Pair( xId.get(y) , measure));
					adj.get( yId.get(y) ).add(new Pair( xId.get(x) , measure));
					adj.get( xId.get(y) ).add(new Pair( yId.get(x) , measure));
				}
			}
			Q=new LinkedList<Integer>();
			for(Integer k: values.keySet()){
				Q.add(k);
			}
			int v;
			while(!Q.isEmpty()){
				v = Q.poll();
				ArrayList<Pair> list = adj.get(v);
				for(int j=0; j<list.size(); j++){
					if(values.containsKey(list.get(j).v))
						continue;
					values.put(list.get(j).v, list.get(j).val - values.get(v));
					Q.add(list.get(j).v);
					if(xFromId.containsKey(list.get(j).v) && yId.containsKey( xFromId.get(list.get(j).v) )){
						values.put( yId.get( xFromId.get(list.get(j).v) ), list.get(j).val - values.get(v));
						Q.add(yId.get( xFromId.get(list.get(j).v) ));
					}
					if(yFromId.containsKey(list.get(j).v) && xId.containsKey( yFromId.get(list.get(j).v) )){
						values.put( xId.get( yFromId.get(list.get(j).v) ), list.get(j).val - values.get(v));
						Q.add(xId.get( yFromId.get(list.get(j).v) ));
					}
				}
			}
			
//			for(Entry<Integer, Integer> e: values.entrySet()){
//				System.out.println(e.getKey()+" "+e.getValue());
//			}
			
			for(int i=0; i<q; i++){
				st=new StringTokenizer(br.readLine());
				x=Integer.parseInt(st.nextToken());
				y=Integer.parseInt(st.nextToken());
				if(!xId.containsKey(x) || !yId.containsKey(y))
					sb.append("*").append("\n");
//					System.out.println("*");
				else if(values.containsKey(xId.get(x)) && values.containsKey(yId.get(y))){
					sb.append(values.get(xId.get(x))+values.get(yId.get(y))).append("\n");
//					System.out.println(values.get(xId.get(x))+values.get(yId.get(y)));
				}
				else{
					Q=new LinkedList<Integer>();
					Q.add(xId.get(x));
					Q.add(0);
					used = new TreeSet<Integer>();
					used.add(xId.get(x));
					int node, val=0;
					boolean ws=false;
					while(!Q.isEmpty()){
						node = Q.poll();
						val=Q.poll();
						if(node == yId.get(y)){
							ws=true;
							break;
						}
						ArrayList<Pair> list = adj.get(node);
						for(int j=0; j<list.size(); j++){
							if(!used.contains(list.get(j).v)){
								used.add(list.get(j).v);
								Q.add(list.get(j).v);
								Q.add(list.get(j).val-val);
							}
						}
					}
					if(ws)
						sb.append(val).append("\n");
//						System.out.println(val);
					else
						sb.append("*").append("\n");
//						System.out.println("*");
				}
			}
			sb.append("-").append("\n");
//			System.out.println("-");
			st = new StringTokenizer(br.readLine());
			m=Integer.parseInt(st.nextToken());
			q=Integer.parseInt(st.nextToken());
		}
		System.out.print(new String(sb));
	}
	
	static class Pair{
		int v;
		int val;
		public Pair(int v, int val) {
			this.v = v;
			this.val = val;
		}
	}
}
