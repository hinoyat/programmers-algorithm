import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        System.out.println(solve(s));
    }

    static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - '0';
            String bin = Integer.toBinaryString(v);
            if (i > 0) {
                if (bin.length() == 1) bin = "00" + bin;
                else if (bin.length() == 2) bin = "0" + bin;
            }
            sb.append(bin);
        }
        return sb.toString();
    }
}
