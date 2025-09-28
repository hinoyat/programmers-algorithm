import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            String s = br.readLine();
            System.out.println(solve(s));
        }
    }

    static String solve(String s) {
        char[] w = s.toCharArray();
        int n = w.length;

        int idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (w[i] < w[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return s;

        int swapIdx = idx + 1;
        for (int j = n - 1; j > idx; j--) {
            if (w[idx] < w[j]) {
                swapIdx = j;
                break;
            }
        }

        char tmp = w[idx];
        w[idx] = w[swapIdx];
        w[swapIdx] = tmp;

        Arrays.sort(w, idx + 1, n);
        return new String(w);
    }
}
