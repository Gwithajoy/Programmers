import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int idx = num - 1;
        System.out.println((char)(0xAC00 + idx));
    }
}