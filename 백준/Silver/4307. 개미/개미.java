import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] ants = new int[N];
            for (int i = 0; i < N; i++) {
                ants[i] = Integer.parseInt(br.readLine());
            }

            int[] ans = solve(L, ants);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }

    static int[] solve(int L, int[] ants) {
        int earliest = 0;
        int latest = 0;

        for (int x : ants) {
            int left = x;
            int right = L - x;
            earliest = Math.max(earliest, Math.min(left, right));
            latest = Math.max(latest, Math.max(left, right));
        }
        return new int[]{earliest, latest};
    }
}
