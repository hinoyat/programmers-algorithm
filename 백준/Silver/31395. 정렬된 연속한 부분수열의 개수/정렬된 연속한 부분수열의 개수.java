import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(solve(arr));
    }

    static long solve(long[] arr) {
        long cnt = 1;
        long sum = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                cnt++;
            } else {
                sum += cnt * (cnt + 1) / 2;
                cnt = 1;
            }
        }
        sum += cnt * (cnt + 1) / 2;
        return sum;
    }
}
