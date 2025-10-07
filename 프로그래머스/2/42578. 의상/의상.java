import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothMap = new HashMap<>();
        
        for (String[] cloth : clothes){
            String type = cloth[1];
            String name = cloth[0];
            
            clothMap.put(type, clothMap.getOrDefault(type, 1) + 1);
        }
        
        for (int cnt : clothMap.values()) {
            answer *= (cnt);
        }
        
        return answer - 1;
    }
}