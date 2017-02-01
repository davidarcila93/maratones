import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DashaAndFriends_761B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k, n;
        k = new Integer(st.nextToken());
        n = new Integer(st.nextToken());
        int a[] = new int[k];
        int b[] = new int[k];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            a[i] = new Integer(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            b[i] = new Integer(st.nextToken());
        }
        int tmp = a[0];
        for(int i=0; i<k; i++) {
            a[i] -= tmp;
        }
        tmp = b[0];
        for(int i=0; i<k; i++) {
            b[i] -= tmp;
        }

        boolean found = false;
        boolean ok = true;
        for(int start=0; !found && start<k; start++) {
            ok = true;
            for(int i=0; ok && i<k; i++) {
                if( ( a[ (start+i)%k ] + n - a[start] ) % n != b[i] )
                    ok = false;
            }
            if( ok )
                found = true;
        }

        if(found)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
