import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> countMap = new HashMap<>(N);
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int q = Integer.parseInt(st.nextToken());
            int cnt = countMap.getOrDefault(q, 0);
            sb.append(cnt).append(' ');
        }

        System.out.println(sb.toString().trim());
    }
}
