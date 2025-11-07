import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static class Node implements Comparable<Node> {
        int v, d;
        Node(int v, int d) { this.v = v; this.d = d; }
        public int compareTo(Node o) { return Integer.compare(this.d, o.d); }
    }

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        List<Edge>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[A] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(A, 0));
        boolean[] vis = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.v;
            if (vis[u]) continue;
            vis[u] = true;
            if (u == B) break;

            for (Edge e : g[u]) {
                int v = e.to, nd = dist[u] + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new Node(v, nd));
                }
            }
        }

        System.out.println(dist[B]);
    }
}
