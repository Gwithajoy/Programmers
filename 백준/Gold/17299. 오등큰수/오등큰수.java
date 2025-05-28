import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int MAX = 1000000;
        int[] freq = new int[MAX+1];
        for (int x : A){
            freq[x]++;
        }
        
        int[] ngf = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++ ) {
            while (!stack.isEmpty() && freq[A[stack.peek()]] < freq[A[i]]) {
                ngf[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        
       while (!stack.isEmpty()) {
           ngf[stack.pop()] = -1;
       }
       
        StringBuilder sb = new StringBuilder();
        for (int x : ngf) {
            sb.append(x).append(' ');
        }
        System.out.println(sb);   
    }
}