class Solution {
    static int N;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        N = numbers.length;
        int total = 0;
        
        for (int i = 0; i < N; i ++ ) {
            total += numbers[i];
        }
        
        findTarget(numbers, total, target, 0, 0);
        
        return answer;
    }
    
    static void findTarget(int[] numbers, int total, int target, int now, int idx) {

        if (idx == N) {
            if (now == target) {
                answer ++;
            }
            return;
        }
        
        if (now + total < target || now - total > target) {
            return;
        }

        findTarget(numbers, total - numbers[idx], target, now - numbers[idx], idx + 1);
        findTarget(numbers, total - numbers[idx], target, now + numbers[idx], idx + 1);
        
    }
}