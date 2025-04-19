import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            if (Good(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean Good(String word){
        Stack<Character> stk = new Stack<>();

        for (char c : word.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == c) {
                stk.pop();
            }else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}
