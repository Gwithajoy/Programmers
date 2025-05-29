import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int d = n / 5;
            int r = n % 5;
            
            String result = "++++ ".repeat(d) + "|".repeat(r);
            result = r == 0 ? result.stripTrailing() : result;
            System.out.println(result);
        }
    }
}
