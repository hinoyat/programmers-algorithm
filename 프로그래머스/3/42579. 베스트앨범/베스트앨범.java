import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        int dataLen = plays.length;
        
        HashMap<String, int[]> genreMap = new HashMap<>();
        
        for (int i = 0; i < dataLen; i++) {
            String curGenre = genres[i];
            int curPlay = plays[i];

            // [0]=총합, [1]=1위 idx, [2]=1위 재생수, [3]=2위 idx, [4]=2위 재생수
            int[] curValues = genreMap.computeIfAbsent(curGenre, g -> new int[]{0, -1, 0, -1, 0});

            int firstIdx   = curValues[1];
            int firstPlay  = curValues[2];
            int secondIdx  = curValues[3];
            int secondPlay = curValues[4];

            // 총합 누적 (정렬 기준)
            curValues[0] += curPlay;

            // 상위 2곡 갱신 (동점이면 인덱스 작은 곡 우선)
            if (curPlay > firstPlay || (curPlay == firstPlay && (firstIdx == -1 || i < firstIdx))) {
                // 기존 1위를 2위로 밀어내기
                curValues[3] = firstIdx;
                curValues[4] = firstPlay;

                // 새 1위
                curValues[1] = i;
                curValues[2] = curPlay;

            } else if (curPlay > secondPlay || (curPlay == secondPlay && (secondIdx == -1 || i < secondIdx))) {
                // 2위만 갱신
                curValues[3] = i;
                curValues[4] = curPlay;
            }
        }

        List<Map.Entry<String, int[]>> ordered = new ArrayList<>(genreMap.entrySet());
        ordered.sort((a, b) -> Integer.compare(b.getValue()[0], a.getValue()[0]));

        // 1위, 2위 인덱스를 순서대로 수집
        List<Integer> tmp = new ArrayList<>();
        for (Map.Entry<String, int[]> e : ordered) {
            int[] s = e.getValue(); // [0]=총합, [1]=1위 idx, [2]=1위 재생, [3]=2위 idx, [4]=2위 재생
            if (s[1] != -1) tmp.add(s[1]);
            if (s[3] != -1) tmp.add(s[3]);
        }

        // List<Integer> -> int[]
        answer = tmp.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}