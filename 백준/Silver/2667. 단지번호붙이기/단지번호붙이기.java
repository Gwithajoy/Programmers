import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        List<Integer> list = new ArrayList<>();
        int total  = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    int cnt = dfs(i, j);
                    list.add(cnt);
                    total++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(total);
        for (int x : list) {
            System.out.println(x);
        }
    }
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] != 0) {
                cnt += dfs(nx, ny);
            }
        }
        return cnt;
    }
}