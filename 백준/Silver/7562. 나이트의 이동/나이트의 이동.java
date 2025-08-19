import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Point {
        int x, y, moves;
        Point(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(l, startX, startY, endX, endY, visited));
        }
    }

    static int bfs(int l, int startX, int startY, int endX, int endY, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == endX && p.y == endY) return p.moves;

            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < l && ny >= 0 && ny < l && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, p.moves + 1));
                }
            }
        }
        return 0;
    }
}
