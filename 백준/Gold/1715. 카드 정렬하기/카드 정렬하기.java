import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            pq.add(x);
        }
        
        int sum = 0;
        int result = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum = a+b;
            result += sum;
            pq.add(sum);
        }
        System.out.println(result);
    }
}