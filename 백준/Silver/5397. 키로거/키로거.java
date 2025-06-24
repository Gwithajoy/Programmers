import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        while (N-- > 0) {
            char[] key = br.readLine().toCharArray();
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();
            
            for (char k : key) {
                switch (k) {
                    case '<' :
                        if (!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>' :
                        if (!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-' :
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(k);
                        break;
                }
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}