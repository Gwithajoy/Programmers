import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T--> 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
        
            int[] A = new int[2 * N + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                A[i + N] = A[i];
            }
            int sum = 0, count = 0;
            for (int i = 1; i <= M; i++) {
                sum += A[i];
            }
            if (sum < K) count++;
            
            if (M == N) {
                System.out.println(count);
                continue;
            }
            
            for (int j = M + 1; j < N + M; j++) {
                sum = sum - A[j - M] + A[j];
                if (sum < K) {
                   count++;
                }
            }
            System.out.println(count);
        }
    }
}