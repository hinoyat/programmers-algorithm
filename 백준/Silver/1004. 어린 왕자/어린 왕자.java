import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine().trim());
            int[][] circles = new int[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                circles[i][0] = Integer.parseInt(st.nextToken());
                circles[i][1] = Integer.parseInt(st.nextToken());
                circles[i][2] = Integer.parseInt(st.nextToken());
            }

            sb.append(solve(x1, y1, x2, y2, circles)).append('\n');
        }

        System.out.print(sb.toString());
    }

    static int solve(int x1, int y1, int x2, int y2, int[][] circles) {
        int cnt = 0;
        for (int[] c : circles) {
            int cx = c[0], cy = c[1], r = c[2];

            long dx1 = x1 - cx, dy1 = y1 - cy;
            long dx2 = x2 - cx, dy2 = y2 - cy;

            long d1 = dx1 * dx1 + dy1 * dy1;
            long d2 = dx2 * dx2 + dy2 * dy2;
            long r2 = (long) r * r;

            boolean in1 = d1 < r2;
            boolean in2 = d2 < r2;

            if (in1 ^ in2) cnt++;
        }
        return cnt;
        }
}
