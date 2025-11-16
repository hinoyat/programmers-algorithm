import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        int[] cost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cost[b] ++;
            graph[a].add(b);
        }

        System.out.println((topologicalSort(graph, cost)));
    }

    static String topologicalSort(ArrayList<Integer>[] graph, int[] cost) {
        int[] answer = new int[N + 1];

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i < N + 1; i ++) {
            if (cost[i] == 0) queue.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(' ');
            for (int next: graph[node]) {
                cost[next] --;
                if (cost[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return sb.toString();
    }

}
