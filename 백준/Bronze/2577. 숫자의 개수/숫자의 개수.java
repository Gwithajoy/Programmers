import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int multiple = a * b * c;
        int[] count = new int[10];
        
        if (multiple == 0) {
            count[0] = 1;
        } else {
            while(multiple > 0) {
                int lastNum = multiple % 10;
                count[lastNum]++;
                multiple /= 10;
            }
        }
        
        for (int cnt : count) {
            System.out.println(cnt);
        }
    }
}