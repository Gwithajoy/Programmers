import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            
            if (absA == absB) return a - b;
            return absA - absB;
        });
        
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            
            if (x == 0) {
                if (pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            } else {
                pq.add(x);
            }
        }
        System.out.print(sb);
    }
}