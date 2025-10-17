import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int N  = sc.nextInt();
        
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            
            if (x == 0) {
                if (maxPQ.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(maxPQ.poll()).append('\n');
                }
            } else {
                maxPQ.add(x);
            }
        }
        System.out.println(sb);
    }
}