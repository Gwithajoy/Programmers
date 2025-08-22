import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);
        dist[N] = 0;
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            
            if (cur == K) {
                System.out.println(dist[cur]);
                return;
            }
            int next = cur * 2;
            if (next < MAX && dist[next] == -1) {
                dist[next] = dist[cur];
                dq.addFirst(next);
            }
            for (int dx : new int[]{-1, 1}) {
                next = cur + dx;
                if (next >= 0 && next < MAX && dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    dq.addLast(next);
                }
            }
        }
    }
}