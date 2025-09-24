import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
       
        final int WAY = 4;
        final int boardLength = board.length;
        
        Map<Integer, int[]> direction = new HashMap<>();
        
        direction.put(0, new int[]{-1, 0});
        direction.put(1, new int[]{1, 0});
        direction.put(2, new int[]{0, -1});
        direction.put(3, new int[]{0, 1});
        
        String targetColor = board[h][w];
        
        for (int i = 0; i < WAY; i++) {
            int[] move = direction.get(i);
            
            int nextY = h + move[0];
            int nextX = w + move[1];
            
            
            if (nextX < 0 || nextX >= boardLength || nextY < 0 || nextY >= boardLength) {
                continue;
            }
            
            if (board[nextY][nextX].equals(targetColor)) {answer ++;}
        
        }
        
        return answer;
    }
}