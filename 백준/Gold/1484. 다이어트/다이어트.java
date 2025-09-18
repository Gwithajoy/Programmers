import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long G = Long.parseLong(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        long l = 1, r = 2;
        boolean found = false;

        while (l < r && r <= 100000) {
            long diff = r*r - l*l; // (r-l)(r+l)
            if (diff == G) {
                sb.append(r).append('\n');
                found = true;
                l++; 
            } else if (diff < G) {
                r++;
            } else { // diff > G
                l++;
            }
        }

        if (!found) System.out.println(-1);
        else System.out.print(sb.toString());
    }
}
