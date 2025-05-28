import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String line = br.readLine().trim();
            Deque<Character> stack = new ArrayDeque<>();
            boolean valid = true;

            for (char ch : line.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else {  // ')'
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (valid && stack.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}
