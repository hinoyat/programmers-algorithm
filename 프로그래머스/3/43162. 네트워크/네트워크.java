import java.util.ArrayDeque;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean [n];
        
        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                bfs(i, n, computers);
                answer ++;
            }
        }

        return answer;
    }
    
    static void bfs(int start, int n, int[][] computers) {
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        queue.addLast(start);
        visited[start] = true;
        
        
        while (!queue.isEmpty()) {
            int now = queue.pollLast();
            
            for (int i = 0; i < n; i ++) {
                if (!visited[i] && computers[now][i] == 1) {
                    visited[i] = true;
                    queue.addLast(i);
                }
            }
            
        }
    }
}