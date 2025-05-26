import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int total = 0;

        for (int i = 0; i < N; i++) {
            int width = sc.nextInt();
            sc.nextInt();

            if (width == 136) {
                total += 1000;
            } else if (width == 142) {
                total += 5000;
            } else if (width == 148) {
                total += 10000;
            } else if (width == 154) {
                total += 50000;
            }
        }

        System.out.println(total);
    }
}
