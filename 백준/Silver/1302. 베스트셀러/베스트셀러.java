import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String item = br.readLine();
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        String bestSelling = "";
        int max = 0;
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String title = entry.getKey();
            int count = entry.getValue();
            
            if (count > max) {
                max = count;
                bestSelling = title;
            } else if (count == max && title.compareTo(bestSelling) < 0) {
                bestSelling = title;
            }
        }
        System.out.println(bestSelling);
    }
}