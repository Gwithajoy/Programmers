import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int V, E, K;
    static List<Edge>[] adj;
    static int[] dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine().trim());
        
        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Edge(v, w));
        }
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dijkstra(K);
        
        StringBuilder sb = new StringBuilder();
        for (int i  = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append('\n');
            }
        }
        System.out.print(sb);
    }
    static class Edge implements Comparable<Edge> {
        int to, w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    
    static void dijkstra(int src) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[src] = 0;
        pq.offer(new Edge(src, 0));
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int u = cur.to, d = cur.w;
            if (d > dist[u]) continue;
            
            for (Edge e : adj[u]) {
                int v = e.to, w = e.w;
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new Edge(v, dist[v]));
                }
            }
        }
    }
}