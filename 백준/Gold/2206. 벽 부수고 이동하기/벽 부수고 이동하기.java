import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited; 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, wallUsed, dist;
        Point(int x, int y, int wallUsed, int dist) {
            this.x = x;
            this.y = y;
            this.wallUsed = wallUsed;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                return p.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (map[nx][ny] == 0 && !visited[nx][ny][p.wallUsed]) {
                    visited[nx][ny][p.wallUsed] = true;
                    q.add(new Point(nx, ny, p.wallUsed, p.dist + 1));
                }

                if (map[nx][ny] == 1 && p.wallUsed == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.add(new Point(nx, ny, 1, p.dist + 1));
                }
            }
        }

        return -1; 
    }
}
