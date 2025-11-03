import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(arr));
    }

    static int solve(int[] arr) {
        int left = 0, right = 0;
        for (int p : arr) {
            if (left <= right) left += p;
            else right += p;
        }

        int diff = Math.abs(left - right);
        int[] w = {100, 50, 20, 10, 5, 2, 1};
        int cnt = 0;
        for (int x : w) {
            cnt += diff / x;
            diff %= x;
        }
        return cnt;
    }
}
