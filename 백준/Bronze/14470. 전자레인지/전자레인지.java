import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); 
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int E = sc.nextInt();
        sc.close();

        int time;
        if (A >= 0) {
            time = (B - A) * E;
        } else {
            time = (-A) * C;
            time += D;
            time += B * E;
        }

        System.out.println(time);
    }
}
