import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] freq = new long[M];
        long sum = 0;
        long answer = 0;
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sum = (sum + Long.parseLong(st.nextToken())) % M;
            freq[(int)sum]++;
        }
        
        answer += freq[0];
        
        for (int r = 0; r < M; r++) {
            long c = freq[r];
            if (c > 1) {
                answer += c * (c - 1) / 2;
            }
        }
        System.out.println(answer);
    }
}