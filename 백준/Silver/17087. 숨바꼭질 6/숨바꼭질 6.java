import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(s - Integer.parseInt(st.nextToken()));
        }

        System.out.println(solve(arr));
    }

    static int solve(int[] arr) {
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int a = gcd;
            int b = arr[i];
            while (b != 0) {
                int r = a % b;
                a = b;
                b = r;
            }
            gcd = a;
        }
        return gcd;
    }
}
