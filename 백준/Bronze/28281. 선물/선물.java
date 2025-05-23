import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long X = sc.nextLong();
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        long minSum = Long.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            long sum = (long)A[i] + A[i+1];
            if (sum < minSum) minSum = sum;
        }
        System.out.println(minSum * X);
    }
}
