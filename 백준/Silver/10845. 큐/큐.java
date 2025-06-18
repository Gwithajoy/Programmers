import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Deque<Integer> queue = new LinkedList<>();
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            
            switch (input[0]) {
                case "push" :
                    queue.offer(Integer.parseInt(input[1]));
                    break;
                case "pop" :
                    sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append("\n");
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front" :
                    sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
                    break;
                case "back" :
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                   break;
            }
        }
        System.out.println(sb);
    }
}