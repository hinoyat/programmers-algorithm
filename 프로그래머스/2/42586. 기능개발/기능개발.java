import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int n = progresses.length;
        
        Deque<Integer> feature = new ArrayDeque<>();
        
        for (int i = 0; i < n; i ++) {
            feature.push(progresses[i]);
        }
        
        int finishCount = 0;
        
        int checkIdx = 0;
        
        List<Integer> finishedList = new ArrayList<>();
        
        while(!feature.isEmpty()) {
            
            // 끝났으면 pop하고 finishCount +1 몇 개 동시에 끝냈는지
            if (progresses[checkIdx] >= 100) {
                finishCount ++;
                checkIdx ++;
                feature.pop();
                if (feature.isEmpty()) {
                    finishedList.add(finishCount);
                }
                
            } else {
            // 끝나기 않을 때 finishCount를 finishedList 배열에 넣어주고 finishCount = 0

                if (finishCount > 0) {
                    finishedList.add(finishCount);
                    finishCount = 0;
                }
                // 진행도 계산
                for (int i = checkIdx; i < n; i ++) {
                    progresses[i] += speeds[i];
                }
                
            }
        }
        
        int totalRelease = finishedList.size();
        
        int[] answer = new int[totalRelease];
        for (int i = 0; i < totalRelease; i++) {
            answer[i] = finishedList.get(i);
        }
        
        return answer;
    }
}