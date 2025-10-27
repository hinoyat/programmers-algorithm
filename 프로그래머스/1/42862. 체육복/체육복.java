import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);

        Set<Integer> both = new HashSet<>(lostSet);
        both.retainAll(reserveSet);

        lostSet.removeAll(both);
        reserveSet.removeAll(both);
        
        TreeSet<Integer> sortedReserveSet = new TreeSet<>(reserveSet);

        for (int r : sortedReserveSet) {
            if (lostSet.contains(r - 1)) {
                lostSet.remove(r - 1);
            } else if (lostSet.contains(r + 1)) {
                lostSet.remove(r + 1);
            }
        }

        return n - lostSet.size();
    }
}
