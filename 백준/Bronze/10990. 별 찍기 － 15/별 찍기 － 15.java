import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i = 1; i <= N; i++) {
            String left = " ".repeat(N - i);
            
            if (i == 1) {
                System.out.println(left + "*");
            } else {
                String mid = " ".repeat(2 * (i - 1) - 1);
                System.out.println(left + "*" + mid + "*");
            }
        }
    }
}
