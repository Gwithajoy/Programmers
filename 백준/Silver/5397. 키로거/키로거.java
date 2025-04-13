import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (T-- > 0) {
            String input = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();

            for (char ch : input.toCharArray()) {
                if (ch == '<') {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                } else if (ch == '>') {
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                } else if (ch == '-') {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                } else {
                    iterator.add(ch);
                }
            }

            for (char c : list) {
                output.append(c);
            }
            output.append("\n");
        }
        System.out.print(output);
    }
}
