import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); 
        }
        
        long count = 0;
        int sum = 0;
        int i = 1, j = 1;
        
        if (N > 0) sum = A[1];
        
        while (i <= N && j <= N) {
            if (sum < M) {
                j++;
                if (j <= N) sum += A[j];
            } else if (sum > M) {
                sum -= A[i];
                i++;
            } else {
                count++;
                sum -= A[i];
                i++;
            }
        }
        System.out.println(count);
    }
}