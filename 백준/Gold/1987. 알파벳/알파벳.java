import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static String[][] map;
    static boolean[][] visited;
    static HashSet<String> set = new HashSet<>();
    static int answer = 0;
    static int R;
    static int C;
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.substring(j, j + 1);
            }
        }

        visited = new boolean[R][C];
        visited[0][0] = true;
        set.add(map[0][0]);

        dfs(0, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int r, int c, int length) {

        answer = Math.max(answer, length);

        for (int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (newR >= R || newC >= C || newR < 0 || newC < 0 || visited[newR][newC]) {
                continue;
            }

            String next = map[newR][newC];
            if (set.contains(next)) {
                continue;
            }

            visited[newR][newC] = true;
            set.add(next);
            dfs(newR, newC, length + 1);
            visited[newR][newC] = false;
            set.remove(next);

        }
    }
}
