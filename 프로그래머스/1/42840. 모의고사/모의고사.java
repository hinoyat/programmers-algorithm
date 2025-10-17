import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int n = answers.length;
        
        
        List<Integer> answer = new ArrayList<>();
        
        int[][] studentAnswer = {
              {1, 2, 3, 4, 5},
              {2, 1, 2, 3, 2, 4, 2, 5},
              {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
            };
                
        int studentN = studentAnswer.length;
        int[] answerLength = new int[studentN];
        int[] studentGrade = new int[studentN];
        
        // 답 길이 세팅
        for (int i = 0; i < studentN; i ++) {
            answerLength[i] = studentAnswer[i].length;
        }
        
        int maxGrade = 0;
        
        for (int i = 0; i < n; i ++) {
            int ans = answers[i];
            
            for (int s = 0; s < studentN; s ++) {
                // 현재 이 학생의 답의 인덱스
                int idx = i % answerLength[s];
                
                if (ans == studentAnswer[s][idx]) {
                    studentGrade[s] ++;
                }
                
                maxGrade = (maxGrade > studentGrade[s]) ? maxGrade : studentGrade[s];
            }
        }
        
        for (int i = 0; i < studentN; i ++) {
            if (studentGrade[i] == maxGrade) {
                answer.add(i + 1);
            }
        }
        
        int[] grade = new int[answer.size()];
    
        for (int i = 0; i < answer.size(); i ++) {
            grade[i] = answer.get(i);
        }
        
        
        return grade;
    }
}