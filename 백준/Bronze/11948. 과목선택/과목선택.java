import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sci = new int[4];
        
        for (int i = 0; i < 4; i++) {
            sci[i] = sc.nextInt();
        }
        
        int history = sc.nextInt();
        int geo = sc.nextInt();

        Arrays.sort(sci);
        int sum = sci[1] + sci[2] + sci[3];

        sum += Math.max(history, geo);
        System.out.println(sum);
    }
}
