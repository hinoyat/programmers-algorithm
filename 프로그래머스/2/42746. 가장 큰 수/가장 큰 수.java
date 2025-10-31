import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        String answer = "";
        String[] stringList = new String[n];
        
        for (int i = 0; i < n; i ++) {
            stringList[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(stringList, (a, b) -> {
            String ab = a + "" + b;
            String ba = b + "" + a;
            return ba.compareTo(ab);
        });
        
        if (stringList[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (String str : stringList) {
            sb.append(str);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}