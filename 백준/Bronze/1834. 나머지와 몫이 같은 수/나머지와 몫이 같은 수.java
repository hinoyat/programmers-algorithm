import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(solve(n));
    }

    static long solve(long n) {
        long sum = 0;
        for (long i = 1; i < n; i++) {
            sum += (n * i + i);
        }
        return sum;
    }
}
