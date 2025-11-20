import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] rooms;
    static int maxLength = 0;
    static int maxValue = 0;
    static int maxValueStart = 0;

    static int[][] dirs = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rooms = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j ++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j ++) {
                if (rooms[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(maxValue);


    }

    static void bfs(int startI, int startJ) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new int[]{startI, startJ, 1, (rooms[startI][startJ])});
        visited[startI][startJ] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int i = info[0];
            int j = info[1];
            int length = info[2];

            for (int[] dir: dirs) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if (newI >= 0 && newI < N && newJ >=0 && newJ < M && rooms[newI][newJ] != 0 && !visited[newI][newJ]) {
                    int newLength = length + 1;
                    int newValue = rooms[startI][startJ] + rooms[newI][newJ];
                    if (newLength > maxLength) {
                        maxLength = newLength;
                        maxValue = newValue;
                    } else if (newLength == maxLength) {
                        maxValue = (maxValue > newValue) ? maxValue : newValue;
                    }
                    visited[newI][newJ] = true;
                    queue.add(new int[]{newI, newJ, newLength, newValue});
                }

            }

        }



    }

}
