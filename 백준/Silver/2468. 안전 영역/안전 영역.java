import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] h;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        h = new int[N][N];
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                h[i][j] = Integer.parseInt(st.nextToken());
                if (h[i][j] > maxH) maxH = h[i][j];
            }
        }
        
        int answer = 1;
        for (int rain = 0; rain < maxH; rain++) {
            visited = new boolean[N][N];
            int cnt = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && h[i][j] > rain ) {
                        bfs(i, j, rain);
                        cnt++;
                    } 
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
    static void bfs(int x, int y, int rain) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0  && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && h[nx][ny] > rain) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }  
            }
        }
    }
}