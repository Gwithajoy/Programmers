import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] A = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < num; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] nge = new int[num];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i  = 0; i < num; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                nge[stack.pop()] = A[i];            
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int x : nge) {
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }
}