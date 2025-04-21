import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] m = new int[N][2];
        for (int i = 0; i < N; i++) {
            m[i][0] = sc.nextInt();
            m[i][1] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(m, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        int cnt = 0, end = 0;
        for (int[] x : m) {
            if (x[0] >= end) {
                end = x[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
