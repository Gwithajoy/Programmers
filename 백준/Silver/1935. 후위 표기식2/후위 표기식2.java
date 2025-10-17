import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String input = br.readLine().trim();
        
        double[] val = new double[N];
        for (int i = 0; i < N; i++) {
            val[i] = Double.parseDouble(br.readLine());
        }
        
        Stack<Double> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch >= 'A'  && ch <= 'Z') {
                stack.push(val[ch - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double res = 0.0;
                
                switch (ch) {
                    case '+': res = a + b; break;
                    case '-': res = a - b; break;
                    case '*': res = a * b; break;
                    case '/': res = a / b; break;
                }

                stack.push(res);
            }
        }
        double result = stack.pop();
        System.out.printf("%.2f", result); 
    }
}