class Solution {
    public int solution(String name) {
        int n = name.length();
        boolean[] finished = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if (name.charAt(i) == 'A') {
                finished[i] = true;
            }
            else {
                answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            }
        }
        
        int minMove = n - 1;
        
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && finished[next]) {
                next++;
            }
            
            minMove = Math.min(minMove, i * 2 + (n - next));
            minMove = Math.min(minMove, (n - next) * 2 + i);
        }
        
        return answer + minMove;
    }
}