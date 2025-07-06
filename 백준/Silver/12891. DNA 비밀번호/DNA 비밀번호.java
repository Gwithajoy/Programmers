import java.util.*;
import java.io.*;

public class Main {
    static int[] curr = new int[4];
    static int[] req = new int[4];
    static int validCount = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        String dna = br.readLine().trim();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            req[i] = Integer.parseInt(st.nextToken());
            if (req[i] == 0) validCount++;
        }
        
        for (int i = 0; i < P; i++) {
           add(dna.charAt(i));
        }
        
        int answer = (validCount == 4) ? 1 : 0;
        
        for (int i = P; i < S; i++) {
            add (dna.charAt(i));
            remove(dna.charAt(i - P));
            if  (validCount == 4) answer++; 
        }
        System.out.println(answer);
    }
    private static void add(char c) {
        int idx = map(c);
        curr[idx]++;
        if (curr[idx] == req[idx]) {
            validCount++;
        }
    }
    
    private static void remove(char c) {
        int idx = map(c);
        if (curr[idx] == req[idx]) {
            validCount--;
        }
        curr[idx]--;
    }
    
    private static int map(char c) {
            switch(c) {
                case 'A': return 0;
                case 'C': return 1;
                case 'G': return 2;
                case 'T': return 3;
                default: return -1;
            
        }
    }
}