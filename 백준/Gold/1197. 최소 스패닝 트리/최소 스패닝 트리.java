import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u; this.v = v; this.w = w;
        } 
        @Override 
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static int[] parent, rank;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            edges[i] = new Edge(
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken())
            );
        }
        Arrays.sort(edges);
        
        parent = new int[V + 1];
        rank = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        long total = 0;
        int usedEdges = 0;
        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                total += e.w;
                if (++usedEdges == V - 1) break;
            }
        }
        System.out.println(total);
    }
    
    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return ;
        if (rank[ra] < rank[b]) {
            parent[ra] = rb;
        } else if (rank[ra] > rank[rb]) {
            parent[rb] = ra;
        } else {
            parent[rb] = ra;
            rank[ra]++;
        }
    }
}