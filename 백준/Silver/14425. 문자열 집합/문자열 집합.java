import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            set.add(br.readLine().trim());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine().trim())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
