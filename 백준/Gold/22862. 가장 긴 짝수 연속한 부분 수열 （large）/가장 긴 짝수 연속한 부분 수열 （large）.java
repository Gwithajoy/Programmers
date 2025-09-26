import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, oddCount = 0, maxLen = 0;

        for (int end = 0; end < N; end++) {
            if (arr[end] % 2 == 1) {
                oddCount++;
            }

            while (oddCount > K) {
                if (arr[start] % 2 == 1) {
                    oddCount--;
                }
                start++;
            }

            maxLen = Math.max(maxLen, (end - start + 1) - oddCount);
        }

        System.out.println(maxLen);
    }
}
