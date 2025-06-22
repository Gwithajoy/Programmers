import java.util.*;
import java.io.*;

public class Main {
     static class Doc {
        int idx, prio;
        Doc(int idx, int prio) {
            this.idx = idx;
            this.prio = prio;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            Deque<Doc> q = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int imp = Integer.parseInt(st.nextToken());
                q.offer(new Doc(i, imp));
                pq.offer(imp);
            }
            
            int printed = 0;
            while (true) {
                Doc cur = q.poll();
                if (cur.prio < pq.peek()) {
                    q.offer(cur);
                } else {
                    printed++;
                    pq.poll();
                    if (cur.idx == M) {
                        sb.append(printed).append('\n');
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}