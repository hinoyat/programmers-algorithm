import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K) {
        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        visited[N] = true;
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                return dist[cur];
            }

            int[] nexts = {cur - 1, cur + 1, cur * 2};

            for (int next : nexts) {
                if (next < 0 || next > 100000) continue; 
                if (visited[next]) continue; 

                visited[next] = true;
                dist[next] = dist[cur] + 1;
                queue.add(next);
            }
        }

        return -1;
    }


}
