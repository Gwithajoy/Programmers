import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        final long cal = 7L * 24 * 60 * 60;

        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        long week = factorial / cal;
        System.out.println(week);

        sc.close();
    }
}
