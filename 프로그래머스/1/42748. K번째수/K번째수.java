import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int commandIdx = 0;
        int[] answer = new int[n];
        
        for (int[] command : commands) {
            int startIdx = command[0] - 1;

            int secondIdx = command[1] - 1;

            int targetIdx = command[2] - 1;

            int size = secondIdx - startIdx + 1;

            int[] slicedArray = new int[size];

            int slicedIdx = 0;

            for (int i = startIdx; i <= secondIdx; i ++) {
                slicedArray[slicedIdx] = array[i];
                slicedIdx ++;
            }
            
            Arrays.sort(slicedArray);
            answer[commandIdx] = slicedArray[targetIdx];
            
            
            
            commandIdx ++;
        }
        
        
        return answer;
    }
}