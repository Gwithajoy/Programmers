import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        int sum = 0;
        int count = 0;

        while (count < 9) {
            sum += sc.nextInt();
            count++;
        }

        System.out.println(total - sum);
    }
}
