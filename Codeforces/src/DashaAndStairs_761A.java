import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DashaAndStairs_761A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int a = Integer.parseInt( sp[0] );
        int b = Integer.parseInt( sp[1] );
        if( a + b == 0 )
            System.out.println("NO");
        else if( Math.abs(a-b) <= 1 )
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
