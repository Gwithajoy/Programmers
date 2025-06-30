import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text  = br.readLine();
        String bomb  = br.readLine();
        int B = bomb.length();

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : text.toCharArray()) {
            stack.push(c);

 
            if (stack.size() >= B) {
                boolean matched = true;
                Iterator<Character> it = stack.iterator();
                for (int i = 0; i < B; i++) {
                    if (it.next() != bomb.charAt(B - 1 - i)) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    for (int i = 0; i < B; i++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.removeLast());
            }
            System.out.println(sb);
        }
    }
}
