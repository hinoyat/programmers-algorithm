import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine().trim());
        int c = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(solve(k, m, n));
        }
    }

    static int solve(int k, int m, int n) {
        if (m == n) return 1;

        if (m < n) {
            // n 쪽이 더 많을 때
            return (n - m - 1 >= k - n + 1) ? 0 : 1;
        } else {
            // m 쪽이 더 많을 때
            return (m - n - 1 > k - m + 1) ? 0 : 1;
        }
    }
}
