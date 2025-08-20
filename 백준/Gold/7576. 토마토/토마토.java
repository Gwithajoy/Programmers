import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        Queue<Point> q = new LinkedList<>();
        
        for (int i = 0;  i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new Point(i, j));
                    }
                }
            }
            while(!q.isEmpty()) {
                Point p = q.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = p.x + dx[dir];
                    int ny = p.y + dy[dir];
                    
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                        map[nx][ny] = map[p.x][p.y] + 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
            int answer = 0; 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        System.out.println(-1);
                        return ;
                    }
                    answer = Math.max(answer, map[i][j]);
                }
            }
            System.out.println(answer - 1);
        }
    }
