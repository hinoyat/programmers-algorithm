import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static int N;
    static char[][] mapNormal;
    static char[][] mapBlind;
    static boolean[][] visited;

    static int[][] dir = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        mapNormal = new char[N][N];
        mapBlind = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                mapNormal[i][j] = c;
                if (c == 'G') {
                    mapBlind[i][j] = 'R';
                } else {
                    mapBlind[i][j] = c;
                }
            }
        }

        visited = new boolean[N][N];
        int normal = countArea(mapNormal);

        visited = new boolean[N][N];
        int blind = countArea(mapBlind);

        System.out.println(normal + " " + blind);
    }

    static int countArea(char[][] map) {
        int areaCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map);
                    areaCount++;
                }
            }
        }

        return areaCount;
    }

    static void bfs(int sx, int sy, char[][] map) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[sx][sy] = true;
        queue.add(new int[] {sx, sy});
        char color = map[sx][sy];

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] != color) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny});
            }
        }
    }
}
