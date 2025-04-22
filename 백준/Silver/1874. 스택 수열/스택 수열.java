import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int curr = 1;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            while (curr <= x) {
                st.push(curr++);
                sb.append("+\n");
            }
            if (st.peek() == x) {
                st.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.print(sb);
    }
}
