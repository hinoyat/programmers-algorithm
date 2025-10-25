import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            String[] clothes = new String[n];
            String[] types = new String[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                clothes[i] = st.nextToken();
                types[i] = st.nextToken();
            }

            System.out.println(solve(types));
        }
    }

    static int solve(String[] types) {
        Map<String, Integer> map = new HashMap<>();
        for (String type : types) {
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int total = 1;
        for (int cnt : map.values()) {
            total *= (cnt + 1);
        }

        return total - 1;
    }
}
