import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> partMap = new HashMap<>();
        
        for (String p : participant) {
            partMap.put(p, partMap.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            partMap.put(c, partMap.get(c) - 1);
            if (partMap.get(c) == 0) {
                partMap.remove(c);
            }
        }

        answer = partMap.keySet().iterator().next();
        
        return answer;
    }
}