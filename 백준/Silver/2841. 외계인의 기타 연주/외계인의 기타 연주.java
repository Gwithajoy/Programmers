import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] strings = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            strings[i] = new Stack<>();
        }

        int moveCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            Stack<Integer> stk = strings[line];

            while(!stk.isEmpty() && stk.peek() > fret) {
                stk.pop();
                moveCount++;
            }

            if (!stk.isEmpty() && stk.peek() == fret) {
                continue;
            }

            stk.push(fret);
            moveCount++;
        }

        System.out.println(moveCount);
    }
}
