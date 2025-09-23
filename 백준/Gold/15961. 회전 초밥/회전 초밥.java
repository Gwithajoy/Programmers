import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] belt = new int[N + k - 1];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k - 1; i++) {
            belt[N + i] = belt[i];
        }

        int[] count = new int[d + 1];
        int kinds = 0;

        for (int i = 0; i < k; i++) {
            if (count[belt[i]] == 0) kinds++;
            count[belt[i]]++;
        }

        int answer = kinds + (count[c] == 0 ? 1 : 0);

        for (int left = 0, right = k; right < N + k - 1; left++, right++) {
            count[belt[left]]--;
            if (count[belt[left]] == 0) kinds--;

            if (count[belt[right]] == 0) kinds++;
            count[belt[right]]++;

            int now = kinds + (count[c] == 0 ? 1 : 0);
            answer = Math.max(answer, now);
        }

        System.out.println(answer);
    }
}