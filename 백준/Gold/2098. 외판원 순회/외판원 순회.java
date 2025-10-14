import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] W;
    static int[][] dp;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dfs(0, 1));
    }

    static int dfs(int cur, int visited) {
        if (visited == (1 << N) - 1) {
            if (W[cur][0] == 0) return INF;
            return W[cur][0];
        }
        if (dp[cur][visited] != -1) return dp[cur][visited];
        dp[cur][visited] = INF;
        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) != 0 || W[cur][next] == 0) continue;
            dp[cur][visited] = Math.min(dp[cur][visited],
                    W[cur][next] + dfs(next, visited | (1 << next)));
        }
        return dp[cur][visited];
    }
}
