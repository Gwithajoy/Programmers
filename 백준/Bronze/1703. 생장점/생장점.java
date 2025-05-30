import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        
        while((input = br.readLine()).trim() != null) {
            if (input.equals("0")) {
                break;
            }
            
            StringTokenizer st = new StringTokenizer(input, " ");

            int age = Integer.parseInt(st.nextToken());
            int leave = 1;
            
            
            for (int i = 1; i <= age; i++) {
                int split = Integer.parseInt(st.nextToken());
                int branch = Integer.parseInt(st.nextToken());
                leave = leave * split - branch;
            }
            System.out.println(leave);
            
        }

    }
}