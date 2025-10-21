class Solution {
    static int answer = - 1;
    static int n;
    static boolean[] visited; 
    
    public int solution(int k, int[][] dungeons) {
        // 최대한 많이 탐험해야 한다
        // 최소 필요 피로도
        // 소모 피로도
        n = dungeons.length;
        visited = new boolean[n];
        
        visitDungeons(k, 0, dungeons, visited);
        
        return answer;
    }
    
    private static void visitDungeons(int k, int depth, int[][] dungeons, boolean visited[]) {
        answer = (depth > answer) ? depth : answer;
        
        for (int i = 0; i < n; i ++) {
            int minimumK = dungeons[i][0];
            int needK = dungeons[i][1];
            if (!visited[i] && k >= minimumK && k >= needK) {
                visited[i] = true;
                visitDungeons(k - needK, depth + 1, dungeons, visited);
                visited[i] = false;
            }
        }
    }
}