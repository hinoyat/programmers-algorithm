class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int n = sizes.length;
        
        // row, col 가로 세로
        
        int row = 0;
        
        int col = 0;
        
        
        for (int i = 0; i < n; i ++) {
            
            int[] curSize = sizes[i];
            
            int r = 0;
            int c = 0;
            
            if (curSize[0] > curSize[1]) {
                r = curSize[0];
                c = curSize[1];
            } else {
                c = curSize[0];
                r = curSize[1];
            }
            
            row = (row > r) ? row: r;
            col = (col > c) ? col: c;
        }
        
        answer = row * col;
        
        
        return answer;
    }
}