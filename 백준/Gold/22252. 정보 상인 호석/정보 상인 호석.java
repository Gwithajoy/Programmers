import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long total = 0;

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (type == 1) {
                int k = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> pq = map.computeIfAbsent(name, key -> new PriorityQueue<>(Comparator.reverseOrder()));
                for (int j = 0; j < k; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            } else { 
                int b = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> pq = map.get(name);
                if (pq != null) {
                    for (int j = 0; j < b && !pq.isEmpty(); j++) {
                        total += pq.poll();
                    }
                }
            }
        }
        System.out.println(total);
    }
}
