import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args ) throws IOException {
        int MAX = 10;
        long[] dp = new long[MAX+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= MAX; i++) {
            dp[i] = dp[i-1]+ dp[i-2] + dp[i-3];
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }
}