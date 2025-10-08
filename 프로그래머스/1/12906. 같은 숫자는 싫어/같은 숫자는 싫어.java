import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        if (n == 0) return new int[0];

        List<Integer> numbers = new ArrayList<>();
        numbers.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                numbers.add(arr[i]);
            }
        }

        int[] answer = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            answer[i] = numbers.get(i);
        }
        return answer;
    }
}
