import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] target = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                target[i] = Integer.parseInt(br.readLine());
            }
            System.out.println(solve(n, target));
        }
    }

    static int solve(int n, int[] target) {
        boolean[] visited = new boolean[n + 1];
        int current = 1;
        int moves = 0;
        visited[current] = true;

        while (true) {
            if (current == n) return moves;
            int next = target[current];
            if (visited[next]) return 0; 
            visited[next] = true;
            current = next;
            moves++;
        }
    }
}
