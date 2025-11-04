import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arrA = new String[n];
        String[] arrB = new String[m];
        for (int i = 0; i < n; i++) arrA[i] = br.readLine();
        for (int i = 0; i < m; i++) arrB[i] = br.readLine();

        System.out.println(solve(arrA, arrB));
    }

    static int solve(String[] a, String[] b) {
        Set<String> set = new HashSet<>();
        for (String s : a) set.add(s);

        int cnt = 0;
        for (String s : b) {
            if (set.contains(s)) cnt++;
        }
        return cnt;
    }
}
