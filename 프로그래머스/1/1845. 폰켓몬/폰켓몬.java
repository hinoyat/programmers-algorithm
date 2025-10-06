import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        
        int n = nums.length;
        
        int limit = n / 2;
        
        HashSet<Integer> kinds  = new HashSet<>();
        
        for (int x : nums) {
            kinds.add(x);
        }
        
        return Math.min(kinds.size(), limit);

    }
}