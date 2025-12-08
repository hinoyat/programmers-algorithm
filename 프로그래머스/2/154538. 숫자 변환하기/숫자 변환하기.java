import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        if (x == y) {
            return 0;
        }
        
        answer = BFS(x, y, n);
        
        return answer;
    }
    
    static int BFS(int start, int end, int n) {
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        
        queue.add(new int[] {start, 0});
        visited.add(start);
        
        while(!queue.isEmpty()) {
            int[] info = queue.pollFirst();
            
            int now = info[0];
            int move = info[1];
            
            int[] values = new int[] {now * 3, now * 2, now + n};
            
            for (int value : values) {
                if (value == end) {
                    return move + 1;
                }
                
                if (!visited.contains(value) && value <= end) {
                    queue.add(new int[] {value, move + 1});
                    visited.add(value);
                    
                }
            }
            
        }
        
        return -1;
    }
}