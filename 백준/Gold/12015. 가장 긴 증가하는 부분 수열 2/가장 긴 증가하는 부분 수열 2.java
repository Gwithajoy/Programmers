import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < N; i++) {
            int now = arr[i];

            if (now > list.get(list.size() - 1)) {
                list.add(now);
            } else {
                int idx = lowerBound(list, now);
                list.set(idx, now);
            }
        }

        System.out.println(list.size());
    }

    static int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }
}
