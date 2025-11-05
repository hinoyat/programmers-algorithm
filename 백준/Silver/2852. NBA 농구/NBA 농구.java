import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = toTime(st.nextToken());
        }

        String[] rslt = solve(data);
        System.out.println(rslt[0]);
        System.out.println(rslt[1]);
    }

    static String[] solve(int[][] data) {
        int aScore = 0, bScore = 0;
        int aTime = 0, bTime = 0;
        int idx = 0, n = data.length;

        for (int t = 0; t < 2880; t++) {
            if (idx < n && data[idx][1] == t) {
                if (data[idx][0] == 1) aScore++;
                else bScore++;
                idx++;
            }

            if (aScore > bScore) aTime++;
            else if (bScore > aScore) bTime++;
        }

        return new String[]{toStringTime(aTime), toStringTime(bTime)};
    }

    static int toTime(String s) {
        String[] t = s.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    static String toStringTime(int t) {
        int h = t / 60, m = t % 60;
        return (h < 10 ? "0" : "") + h + ":" + (m < 10 ? "0" : "") + m;
    }
}
