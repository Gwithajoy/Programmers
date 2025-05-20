import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int a = sc.nextInt();

        int cnt = Math.min(s / 2, a / 2);
        System.out.println(cnt);
    }
}