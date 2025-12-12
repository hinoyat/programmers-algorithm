import java.util.*;

class Solution {
    
    static ArrayDeque<int[]>[] robotQueue;
    static int N;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        N = routes.length;
        
        robotQueue = new ArrayDeque[N];
        
        for (int i = 0; i < N; i ++) {
            robotQueue[i] = new ArrayDeque<>();
        }
        
        // 이동경로 구하기
        for (int i = 0; i < N; i++) {
            int[] startPoint = points[routes[i][0] - 1];
            robotQueue[i].addLast(new int[] {startPoint[0], startPoint[1]}); // t = 0

            for (int j = 1; j < routes[i].length; j++) {
                int[] start = points[routes[i][j - 1] - 1];
                int[] end   = points[routes[i][j] - 1];
                findPath(i, start, end);
            }
        }

        
//         // 이동경로 검증
//         for (int i = 0; i < N; i ++) {
//             System.out.println("로봇 이동 경로" + i);
//             ArrayDeque<int[]> cur = robotQueue[i];
//             while(!cur.isEmpty()) {
//                 int[] curPoint = cur.pollFirst();
//                 System.out.println(curPoint[0] + " " + curPoint[1]);
                
//             }
//         }
        
        while (true) {
            Map<String, Integer> count = new HashMap<>();
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                ArrayDeque<int[]> q = robotQueue[i];
                if (q.isEmpty()) continue;

                moved = true;
                int[] pos = q.pollFirst();
                String key = pos[0] + "," + pos[1];
                count.put(key, count.getOrDefault(key, 0) + 1);
            }

            if (!moved) break;

            for (int c : count.values()) {
                if (c >= 2) answer++;
            }
        }
        
        return answer;
    }
    
    
    static void findPath(int robotNumber, int[] start, int[] end) {
        int startR = start[0];
        int startC = start[1];
        
        int endR = end[0];
        int endC = end[1];
        
        
        while (startR != endR || startC != endC) {

            if (startR != endR) {
                if (startR < endR) {
                    startR ++;
                } else {
                    startR --;
                }    
            } else {
                if (startC < endC) {
                    startC ++;
                } else {
                   startC --; 
                }
            }
            
            robotQueue[robotNumber].addLast(new int[] {startR, startC});
            
        }
        
        
    }
    

}