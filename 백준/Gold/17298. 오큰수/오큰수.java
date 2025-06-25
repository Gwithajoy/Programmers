import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tokens[i]);
        }
        
        int[] nge = new int[N];
        Arrays.fill(nge, -1);
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                int idx = stack.pop();
                nge[idx] = A[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < N; i++) {
            sb.append(nge[i]);
            if (i < N - 1) sb.append(' ');
        }  
        System.out.print(sb);
    }
}