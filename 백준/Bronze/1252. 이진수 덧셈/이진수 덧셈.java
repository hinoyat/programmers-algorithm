import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        System.out.println(solve(A, B));
    }

    static String solve(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int da = (i >= 0) ? (a.charAt(i) - '0') : 0;
            int db = (j >= 0) ? (b.charAt(j) - '0') : 0;
            int sum = da + db + carry;
            sb.append(sum & 1);
            carry = (sum >> 1);
            i--;
            j--;
        }

        String res = sb.reverse().toString();
        int k = 0;
        while (k + 1 < res.length() && res.charAt(k) == '0') k++;
        return res.substring(k);
    }
}
