import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] grid;
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        grid = new char[M][N];
        for (int i = 0; i < M; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        visited = new boolean[M][N];
        
        long wp = 0;
        long bp = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int size = dfs(i, j, grid[i][j]);
                    if (grid[i][j] == 'W') {
                        wp += (long)size * size;
                    } else {
                        bp += (long)size * size;
                    }
                }
            }
        }
        System.out.printf("%d %d\n", wp, bp);
    }
    static int dfs(int x, int y, char color) {
        visited[x][y] = true;
        int count = 1;
        
        for (int d = 0;  d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if (!visited[nx][ny] && grid[nx][ny] == color) {
                count += dfs(nx, ny, color);
            }
        }
        return count;
    }
}