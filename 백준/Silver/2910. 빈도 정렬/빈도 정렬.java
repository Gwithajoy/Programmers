import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> firstIdx = new HashMap<>();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            firstIdx.putIfAbsent(num, i);
        }

        arr.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a);
            } else {
                return firstIdx.get(a) - firstIdx.get(b);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int num : arr) sb.append(num).append(" ");
        System.out.println(sb);
    }
}
