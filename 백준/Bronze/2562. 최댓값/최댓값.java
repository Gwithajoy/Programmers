import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxVal = 0;
        int idx = 0;

        for (int i = 0; i < 9; i++) { 
            int num = sc.nextInt();
            if (num > maxVal) {
                maxVal = num;
                idx = i + 1;
            }
        }

        System.out.println(maxVal);
        System.out.println(idx);
    }
}
