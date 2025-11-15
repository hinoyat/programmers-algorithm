import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static ArrayList<int[]>[] graph;
    static int[] costMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        costMatrix = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < M + 1; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new int[]{end, cost});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Arrays.fill(costMatrix, Integer.MAX_VALUE);
        costMatrix[start] = 0;

        int distance = dijkstra(start, end);
        System.out.println(distance);

    }


    static int dijkstra(int start, int end) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int cost = cur[1];

            if (cost > costMatrix[node]) {
                continue;
            }

            for (int[] next : graph[node]) {
                int nextNode = next[0];
                int nextCost = next[1];
                if (cost + nextCost < costMatrix[nextNode]) {
                    queue.add(new int[]{nextNode, cost + nextCost});
                    costMatrix[nextNode] = cost + nextCost;
                }
            }
        }

        return costMatrix[end];

    }
}
