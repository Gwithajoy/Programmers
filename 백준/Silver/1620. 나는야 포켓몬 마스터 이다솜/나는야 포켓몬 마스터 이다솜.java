import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> nameToIdx = new HashMap<>(N * 2);
        String[] idxToName = new String[N+1];
        
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            idxToName[i] = name;
            nameToIdx.put(name, i);
        }
        
        for (int i = 0; i < M; i++) {
            String input = br.readLine().trim();
            if (Character.isDigit(input.charAt(0))) {
                int idx = Integer.parseInt(input);
                sb.append(idxToName[idx]).append('\n');
            } else {
                sb.append(nameToIdx.get(input)).append('\n');
            }
        }
        System.out.print(sb);
    }
}