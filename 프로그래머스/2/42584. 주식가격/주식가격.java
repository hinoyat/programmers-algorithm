import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        ArrayDeque<Integer> priceDeque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!priceDeque.isEmpty() && prices[i] < prices[priceDeque.peekLast()]) {
                int cur = priceDeque.removeLast();
                answer[cur] = i - cur;
            }
            priceDeque.addLast(i);
        }

        while (!priceDeque.isEmpty()) {
            int cur = priceDeque.removeLast();
            answer[cur] = (n - 1) - cur;
        }

        return answer;
    }
}
