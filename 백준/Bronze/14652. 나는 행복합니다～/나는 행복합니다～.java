import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long K = sc.nextLong();
        sc.close();

        int n = (int)(K / M);
        int m = (int)(K % M);

        System.out.println(n + " " + m);
    }
}
