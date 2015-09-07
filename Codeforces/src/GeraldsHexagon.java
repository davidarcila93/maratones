import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class GeraldsHexagon {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] v= new int[6];
		v[0]=Integer.parseInt(st.nextToken());
		v[1]=Integer.parseInt(st.nextToken());
		v[2]=Integer.parseInt(st.nextToken());
		v[3]=Integer.parseInt(st.nextToken());
		v[4]=Integer.parseInt(st.nextToken());
		v[5]=Integer.parseInt(st.nextToken());
		System.out.println(((v[0]+v[1]+v[2])*(v[0]+v[1]+v[2])-v[0]*v[0]-v[4]*v[4]-v[2]*v[2]));
	}
}
