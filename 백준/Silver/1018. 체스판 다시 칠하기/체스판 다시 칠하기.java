import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            board[i] = row.toCharArray();
        }

        System.out.println(solve(board));
    }

    static int solve(char[][] b) {
        int n = b.length, m = b[0].length;
        int best = 64;
        for (int i = 0; i + 7 < n; i++) {
            for (int j = 0; j + 7 < m; j++) {
                best = Math.min(best, repaint(b, i, j));
            }
        }
        return best;
    }

    static int repaint(char[][] b, int r0, int c0) {
        int diff = 0;
        char start = b[r0][c0];
        char other = (start == 'W') ? 'B' : 'W';
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                char expect = ((r + c) % 2 == 0) ? start : other;
                if (b[r0 + r][c0 + c] != expect) diff++;
            }
        }
        return Math.min(diff, 64 - diff);
    }
}
