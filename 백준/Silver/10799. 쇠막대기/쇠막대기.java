import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        String input = br.readLine().trim();
        
        Deque<Character> stack = new ArrayDeque<>();
        int answer = 0;
        
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            
            if (cur == '(') {
                stack.push(cur);
            } else {
                if (i > 0 && input.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
