import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] pic;
    static boolean[][] visited;
    static int maxArea = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        pic = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                pic[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pic[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(i, j);
                    maxArea = Math.max(maxArea, area);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && pic[nx][ny] == 1) {
                area += dfs(nx, ny);
            }
        }
        return area;
    }
}