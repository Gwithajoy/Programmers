import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            long[] heights = new long[n];
            for (int i = 0; i < n; i++) {
                heights[i] = Long.parseLong(st.nextToken());
            }

            Stack<Integer> stack = new Stack<>();
            long maxArea = 0;

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    long height = heights[stack.pop()];
                    long width = stack.isEmpty() ? i : i - 1 - stack.peek();
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long height = heights[stack.pop()];
                long width = stack.isEmpty() ? n : n - 1 - stack.peek();
                maxArea = Math.max(maxArea, height * width);
            }

            System.out.println(maxArea);
        }
    }
}
