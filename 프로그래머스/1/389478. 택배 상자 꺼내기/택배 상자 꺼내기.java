class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        
        int h = (n + w - 1) / w;
        
        int[][] arr = new int[h][w];
        
        int number = 1;
        
        int startX = 0;
        int startY = 0;
        
        int way = 0;
        
        for (int i = h - 1; i >= 0 && number <= n; i--) {
            int j   = (way == 0) ? 0 : w - 1;
            int dir = (way == 0) ? 1 : -1;

            for (int step = 0; step < w && number <= n; step++, j += dir) {
                arr[i][j] = number;
                if (number == num) {
                    startX = i;
                    startY = j;
                }
                number++;
            }
            way = 1 - way;
        }
        
        while (true) {
            startX --;
            
            if (startX < 0) {break;}
            
            if (arr[startX][startY] != 0) {
                answer ++;    
            }
            
        }
        
        return answer;
    }

}