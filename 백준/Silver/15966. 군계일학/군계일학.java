import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(arr));
    }

    static int solve(int[] a) {
        int[] dp = new int[1_000_001];
        int best = 0;
        for (int v : a) {
            int cur = (v > 0 ? dp[v - 1] : 0) + 1;
            if (cur > dp[v]) dp[v] = cur;
            if (dp[v] > best) best = dp[v];
        }
        return best;
    }
}
