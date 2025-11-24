import java.util.ArrayDeque;

class Solution {
    
    static class Word {
        String word;
        int move;
        Word(String word, int move) {
            this.word = word;
            this.move = move;
        }
    }
    
    
    static int N;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        N = words.length;
        
        visited = new boolean[N];
        
        answer = bfs(begin, target, words);
        
        return answer;
    }
    
    static int bfs(String begin, String target,String[] words) {
        
        ArrayDeque<Word> queue = new ArrayDeque<>();
        queue.add(new Word(begin, 0));
        
        while(!queue.isEmpty()) {
            Word now = queue.pollFirst();
            String nowWord = now.word;
            int nowMove = now.move;
            
            if (nowWord.equals(target)) {
                return nowMove;
            }
            for (int i = 0; i < N; i ++) {
                if (!visited[i]) {
                    if (checkChange(nowWord, words[i])) {
                        queue.add(new Word(words[i], nowMove + 1));
                        visited[i] = true;
                    }
                }
            }

        }
        return 0;
    }
    
    static boolean checkChange(String now, String next) {
        int diff = 0;
        int n = now.length();
        for (int i = 0; i < n; i ++) {
            String s1 = now.substring(i, i + 1);
            String s2 = next.substring(i, i + 1);
            
            if (!s1.equals(s2)) {
                diff ++;
            }
            
            if (diff > 1) {
                return false;
            }
            
        }
        return true;
    }
    
}