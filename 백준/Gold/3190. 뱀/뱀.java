import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static Map<Integer, Character> dirChange = new HashMap<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 2;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            dirChange.put(time, dir);
        }

        System.out.println(simulate());
    }

    static int simulate() {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{0, 0});
        board[0][0] = 1;

        int time = 0;
        int dir = 0;

        while (true) {
            time++;
            int[] head = snake.peekFirst();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 1)
                break;

            snake.addFirst(new int[]{nx, ny});

            if (board[nx][ny] == 2) {
                board[nx][ny] = 1;
            } else {
                board[nx][ny] = 1;
                int[] tail = snake.removeLast();
                board[tail[0]][tail[1]] = 0;
            }

            if (dirChange.containsKey(time)) {
                char c = dirChange.get(time);
                if (c == 'L') dir = (dir + 3) % 4;
                else dir = (dir + 1) % 4;
            }
        }

        return time;
    }
}
