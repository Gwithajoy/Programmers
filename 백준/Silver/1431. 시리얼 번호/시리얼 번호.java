import java.util.*;
import java.io.*;

public class Main {
    static class Comparing implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            
            int sum1 = getSum(s1);
            int sum2 = getSum(s2);
            if (sum1 != sum2) {
                return sum1 - sum2;
            }
            return s1.compareTo(s2);
        }
        private int getSum(String s) {
            int sum = 0;
            for (char c: s.toCharArray()) {
                if (Character.isDigit(c)) sum += c - '0';
            }
            return sum;
        }  
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparing());
        
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}