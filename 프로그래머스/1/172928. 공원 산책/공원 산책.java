import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        int W = park[0].length();
        int H = park.length;
        
        Map<String, int[]> dir = new HashMap<>();
        dir.put("N", new int[]{-1, 0});
        dir.put("S", new int[]{1, 0});
        dir.put("W", new int[]{0, -1});
        dir.put("E", new int[]{0, 1});
        
        // 시작 지점
        int robotI = 0;
        int robotJ = 0;
        boolean findStart = false;
        
        for (int i = 0; i < H; i ++) {
            for (int j = 0; j < W; j++) {
                if (park[i].charAt(j) == 'S') {
                    robotI = i;
                    robotJ = j;
                    findStart = true;
                }
            }
            if (findStart) {break;}
        }
        
        for (int r = 0; r < routes.length; r ++) {
            String[] order = routes[r].split(" ");
            String direction = order[0];
            int value = Integer.parseInt(order[1]);

            int[] move = dir.get(direction);
            
            int tempI = robotI;
            int tempJ = robotJ;
            
            boolean isValid = true;
            
            for (int k = 0; k < value; k++) {
                tempI += move[0];
                tempJ += move[1];
                if (tempI < 0 || tempI >= H || tempJ < 0 || tempJ >= W || park[tempI].charAt(tempJ) == 'X') {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                robotI = tempI;
                robotJ = tempJ;
            }
            
            answer = new int[]{robotI, robotJ};
            
        }
        
        return answer;
    }
}