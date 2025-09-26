import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = 0;
        int del = 0;
        int count = 0;
        int maxLen = 0;

        while (right < N) {
            if (A[right] % 2== 0) {
                count++;
            } else {                   
                del++;
            }

            while (del > K) {
                if (A[left] % 2== 0) count--;
                else del--;
                left++;
            }

            maxLen = Math.max(maxLen, count);
            right++;
        }

        System.out.println(maxLen);
    }
}
