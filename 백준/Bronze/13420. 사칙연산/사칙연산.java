import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            while (line == null || line.trim().isEmpty()) line = br.readLine();

            StringTokenizer st = new StringTokenizer(line);
            long a = Long.parseLong(st.nextToken());
            String op = st.nextToken();
            long b = Long.parseLong(st.nextToken());

            if (st.hasMoreTokens()) {
                String maybeEq = st.nextToken();
                if (!maybeEq.equals("=")) {
                }
            }

            long c = Long.parseLong(st.nextToken());
            System.out.println(solve(a, op, b, c) ? "correct" : "wrong answer");
        }
    }

    static boolean solve(long a, String op, long b, long c) {
        long ans;
        switch (op) {
            case "+": ans = a + b; break;
            case "-": ans = a - b; break;
            case "*": ans = a * b; break;
            case "/": ans = a / b; break;
            default:  return false;
        }
        return ans == c;
    }
}
