import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        long ans = 0L;

        for (int i = 0; i < N - 2; i++) {
            int target = -A[i];
            int l = i + 1, r = N - 1;

            while (l < r) {
                int sum = A[l] + A[r];

                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    if (A[l] != A[r]) {
                        int leftVal = A[l];
                        int cntL = 1;
                        while (l + cntL < r && A[l + cntL] == leftVal) cntL++;

                        int rightVal = A[r];
                        int cntR = 1;
                        while (r - cntR > l && A[r - cntR] == rightVal) cntR++;

                        ans += (long) cntL * cntR; 
                        l += cntL;
                        r -= cntR;
                    } else {
                        int len = r - l + 1;
                        ans += (long) len * (len - 1) / 2;
                        break; 
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
