import java.util.ArrayDeque;

class Solution {
    
    static int N;
    static int M;
    static int[][] dirs = {
        {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        
        answer = bfs(maps);
        
        return answer;
    }
    
    
    static int bfs (int[][] maps) {
        
        boolean[][] visited = new boolean[N][M];
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int x = now[0];
            int y = now[1];
            int move = now[2];
            if (x == N - 1 && y == M - 1) {
                return move;
            }
            
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || maps[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                queue.addLast(new int[] {nx, ny, move + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
    
}