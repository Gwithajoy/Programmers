import java.util.*;
import java.io.*;

public class Main {
    static class Flower implements Comparable<Flower> {
        int start, end;
        public Flower(int sm, int sd, int em, int ed) {
            this.start = sm * 100 + sd;
            this.end = em * 100 + ed;
        }
        public int compareTo(Flower o) {
            if (this.start == o.start) return o.end - this.end;
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(sm, sd, em, ed);
        }
        
        Arrays.sort(flowers);
          
        int START = 301;
        int FINISH = 1130;
        
        int target = START;
        int idx = 0;
        int count = 0;
        int maxEnd = 0;
        
        while (target <= FINISH) {
            boolean found = false;
            
            while (idx < N && flowers[idx].start <= target) {
                if (flowers[idx].end > maxEnd) {
                    maxEnd = flowers[idx].end;
                    found = true;
                }
                idx++;
            }
            
            if (found == false) {
                System.out.println(0);
                return;
            }
            
            count++;
            target = maxEnd;
            
            if (target > FINISH) break;
        }
        System.out.println(count);
    }
}
