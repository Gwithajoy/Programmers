import java.util.*;
import java.io.*;

public class Main {
    static class Pair implements Comparable<Pair> {
        int value, index;
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Pair[] pairs = new Pair[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(A[i], i);
        }

        Arrays.sort(pairs);
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[pairs[i].index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(" ");
        }
        System.out.println(sb);
    }
}
