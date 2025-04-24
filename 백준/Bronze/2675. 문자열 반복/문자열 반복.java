import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int repeatStr = sc.nextInt();
            String str = sc.next();

            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                sb.append(String.valueOf(c).repeat(repeatStr));
            }
            System.out.println(sb);
        }
    }
}
