import java.util.ArrayDeque;

class Solution {
    static int[][] map;
    static int[][] dirs = {
        {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    map[i][j] = 0;
                }
            }
        }

        int sx = characterX * 2;
        int sy = characterY * 2;
        int ex = itemX * 2;
        int ey = itemY * 2;

        int dist = bfs(sx, sy, ex, ey);

        return dist / 2;
    }

    static int bfs(int sx, int sy, int ex, int ey) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sx, sy, 0});
        map[sx][sy]++;

        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int x = now[0];
            int y = now[1];
            int move = now[2];

            if (x == ex && y == ey) {
                return move;
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < 102 && ny < 102 && map[nx][ny] == 1) {
                    queue.add(new int[] {nx, ny, move + 1});
                    map[nx][ny]++;
                }
            }
        }

        return 0;
    }
}
