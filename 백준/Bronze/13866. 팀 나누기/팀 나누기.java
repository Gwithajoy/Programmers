import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        sc.close();

        int diff1 = Math.abs((A + B) - (C + D));
        int diff2 = Math.abs((A + C) - (B + D));
        int diff3 = Math.abs((A + D) - (B + C));

        int answer = Math.min(diff1, Math.min(diff2, diff3));
        System.out.println(answer);
    }
}
