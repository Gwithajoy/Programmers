import java.io.*;

public class Main {
    static int N;
    static int[] col;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        dfs(0);
        System.out.println(count);
    }

    static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int c = 0; c < N; c++) {
            col[row] = c;
            if (isSafe(row)) {
                dfs(row + 1);
            }
        }
    }

    static boolean isSafe(int row) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row]) return false;
            if (Math.abs(col[row] - col[i]) == Math.abs(row - i)) return false;
        }
        return true;
    }
}
