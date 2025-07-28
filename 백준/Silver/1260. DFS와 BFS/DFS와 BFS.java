import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static boolean[] visited;
    static List<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
        
        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');
        
        visited = new boolean[N + 1];
        bfs(V);
        
        System.out.print(sb);
    }
    static void dfs(int u) {
        visited[u] = true;
        sb.append(u).append(' ');
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
    static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(' ');
            for (int v: adj[u]) {
                if (!visited[v]) {
                visited[v] = true;
                q.offer(v);
                
                }
            }
        }
    }
}