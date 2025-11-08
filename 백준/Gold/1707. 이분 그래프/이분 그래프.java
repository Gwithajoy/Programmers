import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] color;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            color = new int[V + 1];
            boolean ok = true;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= V && ok; i++) {
                if (color[i] != 0) continue;
                color[i] = 1;
                q.clear();
                q.add(i);
                while (!q.isEmpty() && ok) {
                    int cur = q.poll();
                    for (int nxt : graph[cur]) {
                        if (color[nxt] == 0) {
                            color[nxt] = -color[cur];
                            q.add(nxt);
                        } else if (color[nxt] == color[cur]) {
                            ok = false;
                            break;
                        }
                    }
                }
            }
            out.append(ok ? "YES\n" : "NO\n");
        }
        System.out.print(out.toString());
    }
}
