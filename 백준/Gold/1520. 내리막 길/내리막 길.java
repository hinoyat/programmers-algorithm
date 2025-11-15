import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;

    static int[][] map;
    static int[][] dp;

    static class MapPoint {
        int x;
        int y;
        public MapPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dir = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        MapPoint startPoint = new MapPoint(N - 1, M - 1);
        int answer = dfs(startPoint);
        System.out.println(answer);
    }

    static int dfs(MapPoint current) {
        int x = current.x;
        int y = current.y;

        if (x == 0 && y == 0) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int[] d : dir) {
            int newX = x + d[0];
            int newY = y + d[1];

            if (newX < 0 || newY < 0 || newX >= N || newY >= M) {
                continue;
            }

            if (map[newX][newY] > map[x][y]) {
                dp[x][y] += dfs(new MapPoint(newX, newY));
            }
        }

        return dp[x][y];
    }
}
