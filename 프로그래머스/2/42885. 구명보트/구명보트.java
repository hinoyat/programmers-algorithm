import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n = people.length;
        
        int firstIdx = 0;
        int secondIdx = n - 1;
        
        Arrays.sort(people);
        
        while (firstIdx <= secondIdx) {
            int first = people[firstIdx];
            int second = people[secondIdx];
            
            if (first + second > limit) {
                secondIdx --;
            } else {
                firstIdx ++;
                secondIdx --;
            }
            
            answer ++;
        }
        
        return answer;
    }
}