import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String name = sc.nextLine();
            if (name.contains("S")) {
                System.out.println(name);
                break;
            }
        }
    }
}
