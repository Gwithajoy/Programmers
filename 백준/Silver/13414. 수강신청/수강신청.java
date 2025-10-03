import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        String[] clicks = new String[L];
        for (int i = 0; i < L; i++) {
            clicks[i] = br.readLine().trim();
        }

        Set<String> seen = new HashSet<>();
        List<String> resultList = new ArrayList<>();

        for (int i = L - 1; i >= 0; i--) {
            String id = clicks[i];
            if (!seen.contains(id)) {
                seen.add(id);
                resultList.add(id);
            }
        }

        Collections.reverse(resultList);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (String id : resultList) {
            sb.append(id).append('\n');
            cnt++;
            if (cnt == K) break;
        }

        System.out.print(sb.toString());
    }
}
