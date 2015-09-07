
public class Main {

	public static void main(String[] args) {
		
		for (int i = 0; i < 100000; i++) {
			int aux=(10000*(i%2)+1000*(i%3)+100*(i%4)+10*(i%5)+(i%6));
			if(i==aux)
				System.out.println(i);
		}
		

	}

}
