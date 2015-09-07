import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Expression_479A {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] v = new int[3];
		for(int i=0; i<3; i++){
			v[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 0;
		max = Math.max(max, (v[0]+v[1])+v[2]  );
		max = Math.max(max, (v[0]*v[1])*v[2]  );
		max = Math.max(max, (v[0]*v[1])+v[2]  );
		max = Math.max(max, v[0]+(v[1]*v[2])  );
		max = Math.max(max, (v[0]+v[1])*v[2]  );
		max = Math.max(max, v[0]*(v[1]+v[2])  );
		System.out.println(max);
	}
}
