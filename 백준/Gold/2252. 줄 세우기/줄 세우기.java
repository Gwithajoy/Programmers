import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 학생
        int M = Integer.parseInt(st.nextToken()); // 비교 수 
        
        List<Integer>[] adj = new ArrayList[N+1];
        int[] indeg = new int[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) { 
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            indeg[B]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1;  i <= N; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(" ");
            for (int v : adj[u]) {
                if (--indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }
        System.out.println(sb);
    }
}