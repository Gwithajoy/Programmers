import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine().trim());
        
        Set<String> set = new HashSet<>();
        PriorityQueue<String>  minHeap = new PriorityQueue<>(
            Comparator
            .comparingInt(String::length)
            .thenComparing(Comparator.naturalOrder())
        );
        while (N-- > 0) {
            set.add(br.readLine().trim());
        }
        minHeap.addAll(set);
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}