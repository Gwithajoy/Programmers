import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int unique = 0;

        for (int i = 0; i < k; i++) {
            if (count[belt[i]] == 0) unique++;
            count[belt[i]]++;
        }

        int max = unique;
        if (count[c] == 0) max++;

        for (int i = 1; i < N; i++) {
            int remove = belt[i - 1];
            count[remove]--;
            if (count[remove] == 0) unique--;

            int add = belt[(i + k - 1) % N];
            if (count[add] == 0) unique++;
            count[add]++;

            int current = unique;
            if (count[c] == 0) current++;
            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
