import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(arr));
    }

    static long solve(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += (long) Math.pow(arr[i], 2) * 2;
            sum += (long) Math.pow(arr[i + 1], 2) * 2;
        }
        return sum;
    }
}
