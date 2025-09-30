import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (S == G) { 
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[F + 1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{S, 0});
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int floor = cur[0], cnt = cur[1];

            int up = floor + U;
            if (U > 0 && up <= F && !visited[up]) {
                if (up == G) { System.out.println(cnt + 1); return; }
                visited[up] = true;
                q.add(new int[]{up, cnt + 1});
            }

            int down = floor - D;
            if (D > 0 && down >= 1 && !visited[down]) {
                if (down == G) { System.out.println(cnt + 1); return; }
                visited[down] = true;
                q.add(new int[]{down, cnt + 1});
            }
        }

        System.out.println("use the stairs");
    }
}
