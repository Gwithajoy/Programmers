import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Deque<Object> stk = new LinkedList<>();
        
        boolean isValid = true;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '(' || ch == '[') {
                stk.push(ch);
            } else {
                if (stk.isEmpty()) {
                    isValid = false;
                    break;
                }
                
                int tmp = 0;
                while (!stk.isEmpty() && stk.peek() instanceof Integer) {
                    tmp += (Integer) stk.pop();
                }
                
                if (stk.isEmpty()) {
                    isValid = false;
                    break;
                }
                
                char op = (char) stk.pop();
                if (ch == ')' && op == '(') {
                    stk.push(tmp == 0 ? 2 : 2 * tmp);
                } else if (ch == ']' && op == '[') {
                    stk.push(tmp == 0 ? 3 : 3 * tmp);
                } else {
                    isValid = false;
                    break;
                }
            }
        }
        
        int result = 0;
        while (!stk.isEmpty()) {
            if (stk.peek() instanceof Integer) {
                result += (Integer) stk.pop();
            } else {
                isValid = false;
                break;
            }
        }
        
        System.out.println(isValid ? result : 0);
    }
}
