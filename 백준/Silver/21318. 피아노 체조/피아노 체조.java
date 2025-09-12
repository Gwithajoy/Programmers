import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] prefix = new int[N];
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i-1];
            if (A[i] > A[i+1]) {
                prefix[i]++;
            }
        }
        
        int Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if (x == y) {
                sb.append(0).append('\n');
            } else {
                sb.append(prefix[y-1] - prefix[x-1]).append('\n');
            }
        }
        
        System.out.print(sb);
    }
}
