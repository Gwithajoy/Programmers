import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            LinkedList<int[]> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                queue.add(new int[]{i, sc.nextInt()});
            }
            int printed = 0;
            while (true) {
                int[] cur = queue.removeFirst();
                boolean higher = false;
                for (int[] q : queue) {
                    if (q[1] > cur[1]) {
                        higher = true;
                        break;
                    }
                }
                if (higher) {
                    queue.addLast(cur);
                } else {
                    printed++;
                    if (cur[0] == M) {
                        System.out.println(printed);
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}
