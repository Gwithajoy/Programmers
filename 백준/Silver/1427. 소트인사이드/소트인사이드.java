import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int d = 9; d >= 0; d--) {
            for (int k = 0; k < cnt[d]; k++)
                sb.append(d);
        }
        System.out.println(sb);
    }
}
