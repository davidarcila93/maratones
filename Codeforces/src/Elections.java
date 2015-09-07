import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Elections {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m, n;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		int votes[][] = new int[n][m];
		
		for(int city=0; city<m; city++){
			st= new StringTokenizer(br.readLine());
			for(int candidate =0; candidate<n; candidate++){
				votes[candidate][city] = Integer.parseInt(st.nextToken());
			}
		}
		int winnerInCities[] = new int[n];
		for(int city=0; city<m; city++){
			int winnerId=-1;
			int winnerVotes=-1;
			for(int candidate =0; candidate<n; candidate++){
				if(votes[candidate][city]>winnerVotes){
					winnerId=candidate;
					winnerVotes=votes[candidate][city];
				}
			}
			winnerInCities[winnerId]++;
		}
		int winnerId=-1;
		int winnerVotes=-1;
		for(int candidate =0; candidate<n; candidate++){
			if(winnerInCities[candidate]>winnerVotes){
				winnerId=candidate;
				winnerVotes=winnerInCities[candidate];
			}
		}
		
		System.out.println(winnerId+1);
	}
}
