import java.io.*;
import java.util.*;

public class Main {
    static class Elem {
        int val, origIdx;
        Elem(int v, int i) { val = v; origIdx = i; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        Elem[] arr = new Elem[N];
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine().trim());
            arr[i] = new Elem(v, i+1);
        }
        
        Arrays.sort(arr, Comparator.comparingInt(e -> e.val));
        
        int maxDiff = 0;
        for (int j = 0; j < N; j++) {
            int diff = arr[j].origIdx - (j+1);
            if (diff > maxDiff) maxDiff = diff;
        }
        
        System.out.println(maxDiff + 1);
    }
}
