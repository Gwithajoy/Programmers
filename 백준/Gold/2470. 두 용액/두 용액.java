import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        long best = Long.MAX_VALUE;
        int answer1 = 0, answer2 = 0;
        
        while (left < right) {
            long sum = (long) arr[left] + arr[right];
            if (Math.abs(sum) < best) {
                best = Math.abs(sum);
                answer1 = arr[left];
                answer2 = arr[right];
            }
            
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}