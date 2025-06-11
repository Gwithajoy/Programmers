import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();

            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (char c : input.toCharArray()) {
                if (c == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else if (c == '<') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                } else if (c == '>') {
                    if (iter.hasNext()) {
                        iter.next();
                    }
                } else {
                    iter.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : list) {
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
    }
}
