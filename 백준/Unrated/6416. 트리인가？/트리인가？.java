import java.io.*;
import java.util.*;

public class Main {
    static int caseNum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Map<Integer, Integer> indegree = new HashMap<>();

            boolean end = false;
            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int u = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());

                    if (u == -1 && v == -1) return;
                    if (u == 0 && v == 0) { end = true; break; }

                    graph.putIfAbsent(u, new ArrayList<>());
                    graph.putIfAbsent(v, new ArrayList<>());

                    graph.get(u).add(v);
                    indegree.put(v, indegree.getOrDefault(v, 0) + 1);
                    indegree.putIfAbsent(u, indegree.getOrDefault(u, 0));
                }
                if (end) break;
            }

            if (graph.isEmpty()) {
                System.out.println("Case " + caseNum++ + " is a tree.");
                continue;
            }

            List<Integer> roots = new ArrayList<>();
            for (int node : graph.keySet()) {
                if (indegree.getOrDefault(node, 0) == 0)
                    roots.add(node);
            }

            boolean isTree = true;

            if (roots.size() != 1) isTree = false;
            else {
                int root = roots.get(0);
                Set<Integer> visited = new HashSet<>();
                dfs(graph, root, visited);

                if (visited.size() != graph.size()) isTree = false;

                for (int node : indegree.keySet()) {
                    if (indegree.get(node) > 1) isTree = false;
                }
            }

            System.out.println("Case " + caseNum++ + (isTree ? " is a tree." : " is not a tree."));
        }
    }

    static void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        visited.add(node);
        for (int next : graph.get(node)) {
            if (!visited.contains(next))
                dfs(graph, next, visited);
        }
    }
}
