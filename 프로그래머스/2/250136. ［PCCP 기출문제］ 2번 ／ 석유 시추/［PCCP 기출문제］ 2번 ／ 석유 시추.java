import java.util.*;

class Solution {
    
    static int N;
    static int M;
    static int[] colValue;
    static boolean[][] visited;
    static int[][] dirs = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
        
        visited = new boolean[N][M];
        colValue = new int[M];
        
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j ++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(i, j, land);
                }
            }
        }
        
        Arrays.sort(colValue);
        
        answer = colValue[colValue.length - 1];
        
        
        return answer;
    }
    
    
    static void bfs(int sx, int sy, int[][] land) {
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sx, sy});
        visited[sx][sy] = true;
        
        HashSet<Integer> colSet = new HashSet<>();
        colSet.add(sy);
        int value = 1;
        
        while(!queue.isEmpty()) {
            int[] info = queue.pollFirst();
            int x = info[0];
            int y = info[1];
            
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.addLast(new int[] {nx, ny});
                    colSet.add(ny);
                    value ++;
                }
            }
        }
        
        for (int col : colSet) {
            colValue[col] += value;
        }
        
        
        
        return;
    }
}