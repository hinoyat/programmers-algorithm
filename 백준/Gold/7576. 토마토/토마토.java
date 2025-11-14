import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Tomato {
        int x;
        int y;
        int day;

        Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int[][] dir = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M];

        boolean[][] isTomato = new boolean[N][M];

        ArrayDeque<Tomato> tomatoQueue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    tomatoQueue.add(new Tomato(i, j, 1));
                    isTomato[i][j] = true;
                }
                if (box[i][j] == -1) {
                    isTomato[i][j] = true;
                }
            }
        }

        int answer = bfs(tomatoQueue, isTomato, box);

        System.out.println(answer);

    }

    static int bfs(ArrayDeque<Tomato> tomatoQueue, boolean[][] isTomato, int[][] box) {
        int totalDay = 0;

        if (checkFull(isTomato)) {
            return totalDay;
        }

        while (!tomatoQueue.isEmpty()) {
            Tomato tomato = tomatoQueue.pollFirst();
            int x = tomato.x;
            int y = tomato.y;
            int day = tomato.day;

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                int nDay = day + 1;
                if (nx >= N || ny >= M || nx < 0 || ny < 0) {
                    continue;
                }
                if (!isTomato[nx][ny] && box[nx][ny] == 0) {
                    tomatoQueue.add(new Tomato(nx, ny, nDay));
                    isTomato[nx][ny] = true;
                    totalDay = Math.max(totalDay, day);
                }
            }

        }

        if (!checkFull(isTomato)) {
            return -1;
        }

        return totalDay;
    }

    static boolean checkFull(boolean[][] isTomato) {
        boolean isFull = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isTomato[i][j]) {
                    return false;
                }
            }
        }

        return isFull;
    }
}
