import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while (!(line = br.readLine()).equals(".")) {
            if (isBalanced(line)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
    
    public static boolean isBalanced(String s) {
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if ( c == '(' || c == '[') {
                stk.push(c);
            } else if (c == ')') {
                if (stk.isEmpty() || stk.peek() != '('){
                    return false;
                }
                stk.pop();
            } else if (c == ']') {
                if (stk.isEmpty() || stk.peek() != '[') {
                    return false;
                }
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}