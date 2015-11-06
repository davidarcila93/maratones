import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class bashing {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n, t;
		StringTokenizer st;
		int[] buttons;
		int[] dist;
		Queue<Integer> q;
		while(T-->0){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			buttons = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++){
				buttons[i] = Integer.parseInt(st.nextToken());
			}
			dist = new int[3601];
			Arrays.fill(dist, -1);
			q = new LinkedList<Integer>();
			q.add(0);
			q.add(0);
			int time, d, aux;
			while(!q.isEmpty()){
				time = q.poll();
				d = q.poll();
				if(dist[time]!=-1)
					continue;
				dist[time] = d;
				for(int i=0; i<n; i++){
					aux = time+buttons[i];
					aux = Math.max(0, aux);
					aux = Math.min(aux, 3600);
					q.add(aux);
					q.add(d+1);
				}
			}
			for(int i=t; i<=3600; i++){
				if( dist[i]!=-1 ){
					System.out.println(dist[i]+" "+(i-t));
					break;
				}
			}
		}
		
		
	}

}
