import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static boolean[][] visited;
    static int[][] pic;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n][m];
        pic = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                pic[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pic[i][j] == 1 && !visited[i][j]) {
                    int area = bfs(i, j);
                    maxArea = Math.max(maxArea, area);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }
    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int area = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && pic[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    area++;
                }
            }
        }
        return area;
    }
}