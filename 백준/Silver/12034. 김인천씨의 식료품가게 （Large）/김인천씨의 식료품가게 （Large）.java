import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder out = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n * 2];
            int idx = 0;
            while (idx < n * 2) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                    continue;
                }
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            String ans = solve(n, arr);
            out.append("Case #").append(tc).append(": ").append(ans).append("\n");
        }

        System.out.print(out);
    }

    static String solve(int n, int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : arr) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (int v : arr) {
            if (res.size() == n) break;

            int c = cnt.getOrDefault(v, 0);
            if (c == 0) continue;
            cnt.put(v, c - 1);

            int prev = v / 3 * 4;
            int pc = cnt.getOrDefault(prev, 0);
            if (pc > 0) {
                cnt.put(prev, pc - 1);
                res.add(v);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(res.get(i));
        }
        return sb.toString();
    }
}
