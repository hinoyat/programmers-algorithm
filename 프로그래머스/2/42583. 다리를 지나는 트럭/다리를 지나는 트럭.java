import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int curWeight = 0;
        int idx = 0;

        for (int i = 0; i < bridge_length; i++) bridge.addLast(0);

        while (idx < truck_weights.length || curWeight > 0) {
            time++;
            curWeight -= bridge.pollFirst();

            if (idx < truck_weights.length && curWeight + truck_weights[idx] <= weight) {
                
                bridge.addLast(truck_weights[idx]);
                curWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.addLast(0);
            }
        }

        return time;
    }
}
