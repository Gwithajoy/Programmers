import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Set<String> sorted = new TreeSet<>(
            Comparator.comparingInt(String::length)
                      .thenComparing(Comparator.naturalOrder())
        );
        
        for (int i = 0;  i < N; i++) {
            sorted.add(br.readLine().trim());
        }
        
        StringBuilder sb = new StringBuilder();
        for (String w : sorted) {
            sb.append(w).append('\n');
        }
        System.out.print(sb);
    }
}