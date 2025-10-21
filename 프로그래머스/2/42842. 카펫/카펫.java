class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 사각형 가로  = yellow 가로 + 2
        // 사각형 세로 = yellow 세로 + 2
        
        // yellow의 row, col 구하면서 나뉘어 떨어 질 때 (row * 2) + (col * 2) + 꼭짓점(4) 가 brown 수와 같으면
       
        
        for (int i = 1; i <= (yellow / 2) +  1; i ++) {
            if (yellow % i == 0) {
                int row = i;
                int col = yellow / i;    
                if (isMatch(row, col, brown)) {
                    answer = new int[] {col + 2, row + 2};
                    break;
                };
            }
        }
        
        
        return answer;
    }
    
    
    private static boolean isMatch(int row, int col, int brown) {
        int value = (row * 2) + (col * 2) + 4;
        if (value == brown) {
            return true;
        }
        
        return false;
    }
}