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

        int[] count = new int[100001];
        int left = 0, right = 0;
        int answer = 0;

        while (right < N) {
            int num = arr[right];

            if (count[num] < K) {
                count[num]++;
                right++;
                answer = Math.max(answer, right - left);
            } else {
                count[arr[left]]--;
                left++;
            }
        }

        System.out.println(answer);
    }
}
