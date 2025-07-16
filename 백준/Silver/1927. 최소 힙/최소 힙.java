import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine().trim());
            if (cmd != 0) {
                minHeap.offer(cmd);
            } else {
                if (minHeap.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                sb.append(minHeap.poll()).append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}