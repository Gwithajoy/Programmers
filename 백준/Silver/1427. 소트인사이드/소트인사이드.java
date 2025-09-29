import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        
        char[] num = N.toCharArray();
        Arrays.sort(num);
        
        StringBuilder sb = new StringBuilder(new String(num));
        System.out.println(sb.reverse().toString());
        
    } 
}