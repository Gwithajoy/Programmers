import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(
            new InputStreamReader(System.in)).readLine().trim());

        int count = 0;
        for (int k = 1; k * (k - 1) / 2 < N; k++) {
            int numerator = N - (k * (k - 1) / 2);
            if (numerator % k == 0) {
                int a = numerator / k;
                if (a >= 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
