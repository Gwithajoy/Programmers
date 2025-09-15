import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x2 - x1;
            int dy = y2 - y1;
            int distSq = dx * dx + dy * dy;

            int rSum = (r1 + r2) * (r1 + r2);
            int rDiff = (r1 - r2) * (r1 - r2);

            if (distSq == 0 && r1 == r2) {
                System.out.println(-1); 
            } else if (distSq == rSum || distSq == rDiff) {
                System.out.println(1); 
            } else if (rDiff < distSq && distSq < rSum) {
                System.out.println(2); 
            } else {
                System.out.println(0);
            }
        }
    }
}
