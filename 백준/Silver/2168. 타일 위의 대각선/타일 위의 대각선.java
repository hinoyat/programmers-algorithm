import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        System.out.println(solve(x, y));
    }

    static int solve(int x, int y) {
        int a = x, b = y;
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        int gcd = a;
        return ((x / gcd) + (y / gcd) - 1) * gcd;
    }
}
