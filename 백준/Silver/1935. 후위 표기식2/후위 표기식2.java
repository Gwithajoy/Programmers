import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String equation = sc.nextLine();
        double[] values = new double[num];
        for (int i = 0; i < num; i++) {
            values[i] = Double.parseDouble(sc.nextLine());
        }
        Deque<Double> stk = new ArrayDeque<>();
        for (char c : equation.toCharArray()) {
            if (c >= 'A' && c < 'A' + num) {
                stk.push(values[c - 'A']);
            } else {
                double b = stk.pop();
                double a = stk.pop();
                switch (c) {
                    case '+':
                        stk.push(a + b);
                        break;
                    case '-':
                        stk.push(a - b);
                        break;
                    case '*':
                        stk.push(a * b);
                        break;
                    case '/':
                        stk.push(a / b);
                        break;
                }
            }
        }
        System.out.printf("%.2f\n", stk.pop());
        sc.close();
    }
}
