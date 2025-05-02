import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        sc.close();

        int total = A + B;
        int cost = 2 * C;

        System.out.println(total >= cost ? total - cost : total);
    }
}
