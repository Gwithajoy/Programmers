import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append(c); 
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)
                       && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        System.out.println(sb.toString());
    }
    private static int precedence (char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            default:             return 0;
        }
    }
}