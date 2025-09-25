import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }
        
        for (String name : callings) {
            int curRank = rankMap.get(name);

            String front = players[curRank - 1];
            players[curRank - 1] = name;
            players[curRank] = front;

            rankMap.put(name, curRank - 1);
            rankMap.put(front, curRank);
        }
        
        return players;
    }
}
