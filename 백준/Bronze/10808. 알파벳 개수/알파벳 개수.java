import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int count = input.length() - input.replace(String.valueOf(ch), "").length();
            System.out.print(count+" ");
        }
    }
}