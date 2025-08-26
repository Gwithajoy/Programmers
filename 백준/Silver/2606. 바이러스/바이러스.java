import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static List<Integer>[] adj;
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
        
        visited = new boolean[N+1];
        dfs(1);
        System.out.println(count);
    }
    
    static void dfs(int u) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v);
                count++;
            }
        }
    }
}