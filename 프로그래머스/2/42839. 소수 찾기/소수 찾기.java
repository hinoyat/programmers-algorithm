import java.util.*;

class Solution {
    static int answer; 
    static int N;
    static String[] numberList;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static HashSet <String> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        answer = 0;
        
        N = numbers.length();
        numberList = new String[N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i ++) {
            numberList[i] = numbers.substring(i, i + 1);
        }
        
        Arrays.sort(numberList);
        
        makeNumbers();
        
        countPrime();
      
        
        
        return answer;
    }
    
    
    static void makeNumbers() {
        
        if (sb.length() > 0) {
            numberSet.add(sb.toString());
            // System.out.println(sb.toString());
        }
        
        for (int i = 0; i < N; i ++) {
            if (visited[i]) { continue; }
            if (sb.length() == 0 && numberList[i].equals("0")) { continue; }
            
            visited[i] = true;
            sb.append(numberList[i]);
            makeNumbers();
            sb.setLength(sb.length() - 1);
            visited[i] = false;
        }
    }
    
    
    static void countPrime() {
        for (String num : numberSet) {
            int number = Integer.parseInt(num);
            if (isPrime(number)) {
                answer ++;
            }
        }
    }
    
    static boolean isPrime(int number) {
        
        if(number < 2) return false;

        if(number == 2) return true;

        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}