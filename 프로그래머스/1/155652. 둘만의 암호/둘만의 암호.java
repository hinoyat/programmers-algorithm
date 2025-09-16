class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        boolean[] skipped = new boolean[26];
        
        for (int i = 0; i < skip.length(); i++) {
            skipped[skip.charAt(i) - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            
            int x = s.charAt(i) - 'a';
            
            int moved = 0;

            while (moved < index) {
                x = (x + 1) % 26;
                if (!skipped[x]) {
                    moved++;
                }
            }

            sb.append((char) ('a' + x));
        }

        answer = sb.toString();
        
        return answer;
    }
}