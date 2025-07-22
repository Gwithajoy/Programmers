import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] cables = new long[K];
        long maxLen = 0;
        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine().trim());
            if (cables[i] > maxLen) {
                maxLen = cables[i];
            }
        }

        long low = 1, high = maxLen + 1;
        while (low < high) {
            long mid = (low + high) / 2;
            long count = 0;
            for (long len : cables) {
                count += len / mid;
            }
            if (count >= N) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println(low - 1);
    }
}
