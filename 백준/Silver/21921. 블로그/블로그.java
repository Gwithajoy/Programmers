import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += A[i];
        }
        
        int max = sum;
        int count = 1;
        for (int j = K + 1; j <= N; j++) {
            sum = sum - A[j - K] + A[j];
            
            if (max < sum) {
                max = sum;
                count = 1;
            } else if (max == sum) {
                count++;
            } 
        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }

    }
}