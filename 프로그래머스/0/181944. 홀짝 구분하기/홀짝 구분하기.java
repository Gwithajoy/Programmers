import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if (n % 2 == 0) {
            System.out.printf("%s is even", n);
        } else {
            System.out.printf("%s is odd", n);
        }
    }
}