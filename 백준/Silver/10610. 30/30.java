import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solve(s));
    }

    static String solve(String s) {
        int[] cnt = new int[10];
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            cnt[d]++;
            sum += d;
        }

        if (cnt[0] == 0 || sum % 3 != 0) return "-1";

        StringBuilder sb = new StringBuilder();
        for (int d = 9; d >= 0; d--) {
            while (cnt[d] > 0) {
                sb.append(d);
                cnt[d]--;
            }
        }
        return sb.toString();
    }
}
