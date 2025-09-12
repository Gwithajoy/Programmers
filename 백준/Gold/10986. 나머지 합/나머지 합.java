import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[] count = new long[M];
        long answer = 0;
        
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());
            int r = (int)(sum % M);
            if (r == 0) answer++;
            count[r]++;
        }
        for (int i  =0; i < M; i++) {
            if (count[i] > 1) {
                answer += (count[i] * (count[i] - 1)) / 2;
            } 
        }
         System.out.println(answer);
    }
}