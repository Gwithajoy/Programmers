import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};   
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        grid = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        
        visited = new boolean[N][N];
        int normalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j], false);
                    normalCount++;
                }
            }
        }
       
        visited = new boolean[N][N];
        int blindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j], true);
                    blindCount++;
                }
            }
        }
        System.out.printf("%d %d\n", normalCount, blindCount);
        
    }
        
        static void dfs(int x, int y, char color, boolean colorBlind) {
            visited[x][y] = true;
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                
                char nextColor = grid[nx][ny];
                if (colorBlind) {
                    if (isRG(color) && isRG(nextColor)) {
                        dfs(nx, ny, color, true);
                    } else if (color == nextColor) {
                        dfs(nx, ny, color, true);
                    }
                } else {
                    if (nextColor == color) {
                        dfs(nx, ny, color, false);
                    }
                }
            }
        }
        static boolean isRG(char c) {
            return c == 'R' || c == 'G';
        }
    }
