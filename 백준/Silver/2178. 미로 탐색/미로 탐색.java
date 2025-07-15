import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] maze;
    static int[][] dist;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        dist = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line[j] - '0';
            }
        }
        bfs();
        System.out.println(dist[N-1][M-1]);
        
    }
    static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (maze[nx][ny] == 0 || dist[nx][ny] != 0) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}