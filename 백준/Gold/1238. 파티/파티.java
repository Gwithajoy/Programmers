import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, cost;
        Edge(int to, int cost) { this.to = to; this.cost = cost; }
    }

    static final int INF = 1_000_000_000;
    static int N, M, X;
    static List<Edge>[] graph, reverse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverse = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w)); 
            reverse[v].add(new Edge(u, w));
        }

        int[] distTo = dijkstra(graph, X);  
        int[] distFrom = dijkstra(reverse, X); 

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, distTo[i] + distFrom[i]);
        }
        System.out.println(maxTime);
    }

    static int[] dijkstra(List<Edge>[] g, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.cost > dist[cur.to]) continue;
            for (Edge next : g[cur.to]) {
                int newCost = cur.cost + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Edge(next.to, newCost));
                }
            }
        }
        return dist;
    }
}
