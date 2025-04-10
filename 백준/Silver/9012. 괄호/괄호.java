import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < num; i++) {
            String line = sc.nextLine().trim();
            System.out.println(yesOrNo(line) ? "YES" : "NO");
        }
        sc.close();
    }
    
    public static boolean yesOrNo(String s){
        Stack<Character> stk = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(c);
            } else if(c == ')') {
                if (stk.isEmpty()) {
                    return false;
                }
                stk.pop();
            }
        }
        
        return stk.isEmpty();
    }
}