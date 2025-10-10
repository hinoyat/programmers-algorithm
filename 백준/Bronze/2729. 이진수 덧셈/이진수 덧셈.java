import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            String line;
            while ((line = br.readLine()) != null && line.trim().isEmpty()) {}
            if (line == null) break;

            String[] parts = line.trim().split("\\s+");
            while (parts.length < 2) {
                String next = br.readLine();
                if (next == null) break;
                line = (line + " " + next).trim();
                parts = line.split("\\s+");
            }

            String A = parts[0];
            String B = parts[1];
            out.append(solve(A, B)).append('\n');
        }

        System.out.print(out.toString());
    }

    static String solve(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int da = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int db = (j >= 0) ? b.charAt(j--) - '0' : 0;
            int sum = da + db + carry;
            sb.append(sum & 1);
            carry = sum >> 1;
        }

        String res = sb.reverse().toString();
        int k = 0;
        while (k + 1 < res.length() && res.charAt(k) == '0') k++;
        return res.substring(k);
    }
}
