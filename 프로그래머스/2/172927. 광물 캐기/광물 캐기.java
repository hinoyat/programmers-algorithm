import java.util.Arrays;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int n = minerals.length;

        // 캘 수 있는 최대 광물 수
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMinerals = totalPicks * 5;
        int limit = Math.min(n, maxMinerals);

        // 필요한 구간 수
        int seq = (limit + 4) / 5;

        // 각 곡괭이 개수
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];

        // 다이아 곡괭이로 캤을 때 피로도
        int[] diaSeq = new int[seq];
        // 철 곡괭이로 캤을 때 피로도
        int[] ironSeq = new int[seq];
        // 돌 곡괭이로 캤을 때 피로도
        int[] stoneSeq = new int[seq];

        int seqN = 0;

        for (int i = 0; i < limit; i++) {
            String mineral = minerals[i];

            switch (mineral) {
                case "diamond" -> {
                    diaSeq[seqN] += 1;
                    ironSeq[seqN] += 5;
                    stoneSeq[seqN] += 25;
                }
                case "iron" -> {
                    diaSeq[seqN] += 1;
                    ironSeq[seqN] += 1;
                    stoneSeq[seqN] += 5;
                }
                case "stone" -> {
                    diaSeq[seqN] += 1;
                    ironSeq[seqN] += 1;
                    stoneSeq[seqN] += 1;
                }
            }

            // 5개 단위로 다음 구간
            if ((i + 1) % 5 == 0) {
                seqN++;
                if (seqN >= seq) {
                    break;
                }
            }
        }

        // 여기서 diaSeq / ironSeq / stoneSeq를 이용해 정렬
        int[][] totalSeq = new int[seq][3];
        
        for (int i = 0; i < seq; i ++) {
            totalSeq[i][0] = diaSeq[i];
            totalSeq[i][1] = ironSeq[i];
            totalSeq[i][2] = stoneSeq[i];
        }
        
        Arrays.sort(totalSeq, (a, b) -> b[2] - a[2]);
        
        int answer = 0;
        
        for (int i = 0; i < seq; i++) {
            if (dia > 0) {
                answer += totalSeq[i][0];
                dia--;
            } else if (iron > 0) {
                answer += totalSeq[i][1];
                iron--;
            } else if (stone > 0) {
                answer += totalSeq[i][2];
                stone--;
            } else {
                break;
            }
        }

        return answer;
    }
}
