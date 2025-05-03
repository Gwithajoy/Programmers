import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double S = sc.nextDouble();
        double T = sc.nextDouble();
        double D = sc.nextDouble();
        sc.close();

        double time = D / (2 * S);
        double F = T * time;

        System.out.printf("%.0f\n", F);
    }
}
