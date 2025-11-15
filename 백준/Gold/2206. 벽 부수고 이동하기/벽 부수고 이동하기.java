import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] dir = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited = new boolean[N][M][2];

        queue.add(new int[] {0, 0, 1, 0});
        visited[0][0][0] = true;

        int answer = bfs(queue);
        System.out.println(answer);

    }

    static int bfs(ArrayDeque<int[]> queue) {
        if (N == 1  && N == M) {
            return 1;
        }


        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int move = cur[2];
            int breakCount = cur[3];

            for (int[] dir : dir) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX == N - 1 && newY ==  M - 1) {
                    return move + 1;
                }

                if (newX >= N || newY >= M || newX < 0 || newY < 0) {
                    continue;
                } else {
                    if (map[newX][newY] == 1) {
                        if (breakCount == 0 && !visited[newX][newY][1]) {
                            visited[newX][newY][1] = true;
                            queue.add(new int[] {newX, newY, move + 1, breakCount + 1});
                        }
                    }
                    if (map[newX][newY] == 0) {
                        if (!visited[newX][newY][0] && breakCount == 0) {
                            visited[newX][newY][0] = true;
                            queue.add(new int[] {newX, newY,move + 1, breakCount});
                        } else if (breakCount == 1 && !visited[newX][newY][1]) {
                            visited[newX][newY][1] = true;
                            queue.add(new int[] {newX, newY,move + 1, breakCount});
                        }

                    }

                }

            }

        }

        return -1;
    }
}
