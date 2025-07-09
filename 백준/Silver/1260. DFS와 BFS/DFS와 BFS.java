import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());            
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        visited = new boolean[N+1];
        dfs(V);
        sb.append('\n');
        
        
        visited = new boolean[N+1];
        bfs(V);
        
        
        System.out.print(sb.toString());
         
    }
    // dfs -> 재귀
    static void dfs(int u) {
        visited[u] = true;
        sb.append(u).append(' ');
        for (int v: graph[u]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
    // bfs -> 큐
    static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(" ");
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }
}
