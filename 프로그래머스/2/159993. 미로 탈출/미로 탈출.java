import java.util.*;

class Solution {
    static int N;
    static int M;
    static int[][] newMap;
    static int[][] dirs = {
        {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };
    
    static int answer;
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        newMap = new int[N][M];
        
        int[] point = new int[2];
        
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j ++) {
                String s = maps[i].substring(j, j + 1);
                // 시작지점 0, 출구 1, 레버 2, 통로 0, 벽 -1; 
                if (s.equals("S")) {
                    point[0] = i;
                    point[1] = j;
                    newMap[i][j] = 0;
                } else if (s.equals("E")) {
                    newMap[i][j] = 1;
                } else if (s.equals("L")) {
                    newMap[i][j] = 2;
                } else if (s.equals("O")) {
                    newMap[i][j] = 0;
                } else {
                    newMap[i][j] = -1;
                }

            }
        }
        
        // 레버 찾기
        int[] leverPoint = new int[2];
        int[] endPoint = new int[2];
        
        leverPoint = bfs(2, point[0], point[1]);
        
        if (leverPoint[0] == -1) {
            return -1;
        }
        
        endPoint = bfs(1, leverPoint[0], leverPoint[1]);
        
        if (endPoint[0] == -1) {
            return -1;
        }
        
        return answer;
    }
    
    static int[] bfs(int target, int sx, int sy) {
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[] {sx, sy, 0});
        visited[sx][sy] = true;
    
        while (!queue.isEmpty()) {
            int[] info = queue.pollFirst();
            int x = info[0];
            int y = info[1];
            int move = info[2];
            
            if (newMap[x][y] == target) {
                answer += move;
                return new int[] {x, y};
            }
            
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && newMap[nx][ny] != -1) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, move + 1});
                }
            };
        }
        
        return new int[] {-1, -1};
    }
}