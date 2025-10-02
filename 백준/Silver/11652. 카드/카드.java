import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        Map<Long, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int max = 0;
        long result = Long.MAX_VALUE;
        
        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            long key = e.getKey();
            int cnt = e.getValue();
            
            if (cnt > max || (cnt == max && key < result)) {
                max = cnt;
                result = key;
            } 
        }
        System.out.print(result);
    }
}