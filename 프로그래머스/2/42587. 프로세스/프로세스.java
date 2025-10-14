import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int maxPriority = 9;
        int n = priorities.length;
        
        int answer = 0;
        
        int[] priorityCount = new int[maxPriority + 1];
        
        Deque<int[]> process = new ArrayDeque<>();
        
        int maxValue = maxPriority;
        
        for (int i = 0; i < n; i ++) {
            process.addLast(new int[]{priorities[i], i});
            priorityCount[priorities[i]] ++;
        }
        
        
        while (!process.isEmpty()) {
            
            // 최댓값 갱신
            if (priorityCount[maxValue] == 0) {
                for (int c = maxValue - 1; c >= 0; c --) {
                    if (priorityCount[c] > 0) {
                        maxValue = c;
                        break;
                    }
                }
            }
            
            int curProcess[] = process.removeFirst();
            
            int curValue = curProcess[0];
            int curIdx = curProcess[1];
            
            // 현재가 최대인지 체크
            if (curValue == maxValue) {
                priorityCount[maxValue] --;
                answer ++;
                
                if (curIdx == location) { break; }
                
            } else {
                process.addLast(curProcess);
            }

        }
        
        
        return answer;
    }
}