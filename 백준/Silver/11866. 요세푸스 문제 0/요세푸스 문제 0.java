import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }
        
        sb.append('<');
        while (!dq.isEmpty()) {
            for (int i = 1; i < K; i++) {
                dq.offer(dq.poll());
            }
            sb.append(dq.poll());
            if (!dq.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}