import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine().trim());

        while (N-- > 0) {
            String[] line = br.readLine().split(" ");
            String cmd = line[0];


            switch (cmd) {
                case "push":
                    int x = Integer.parseInt(line[1]);
                    queue.offer(x);
                    break;

                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll())
                      .append('\n');
                    break;

                case "size":
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0)
                      .append('\n');
                    break;

                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek())
                      .append('\n');
                    break;

                case "back":
                    sb.append(queue.isEmpty() ? -1 
                          : ((ArrayDeque<Integer>)queue).peekLast())
                      .append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }
}
