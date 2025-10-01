import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n));
    }

    static long solve(int n) {
        boolean[] prime = new boolean[8_000_002];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        List<Long> list = new ArrayList<>();
        for (int i = 2; i < 8_000_000; i++) {
            if (!prime[i]) list.add((long) i);
        }

        return list.get(n - 1);
    }
}
