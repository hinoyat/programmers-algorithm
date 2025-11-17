import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<int[]>[] bridges;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bridges = new ArrayList[N + 1];
        visited = new int[N + 1];

        Arrays.fill(visited, -1);

        for (int i = 1; i < N + 1; i++) {
            bridges[i] = new ArrayList<>();
        }

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            bridges[a].add(new int[] {b, value});
            bridges[b].add(new int[] {a, value});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);

        System.out.println(visited[end]);
    }

    static void bfs(int start, int end) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );
        queue.add(new int[] {start, Integer.MAX_VALUE});
        visited[start] = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curPoint = cur[0];
            int curValue = cur[1];

            if (visited[curPoint] > curValue) continue;

            for (int[] next : bridges[curPoint]) {
                int nextPoint = next[0];
                int nextValue = next[1];

                int possible;
                if (curValue < nextValue) {
                    possible = curValue;
                } else {
                    possible = nextValue;
                }

                if (visited[nextPoint] < possible) {
                    visited[nextPoint] = possible;
                    queue.add(new int[] {nextPoint, possible});
                }
            }

        }

    }
}
