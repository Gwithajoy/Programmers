import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        Stack<Character> stk = new Stack<>();
        int result = 0;

        for (int i = 0; i < line.length(); i++) {
            char curr = line.charAt(i);

            if (curr == '(') {
                stk.push('(');
            } else {
                stk.pop();

                if (line.charAt(i - 1) == '(') {
                    result += stk.size();
                } else {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
