import java.util.*;
import java.io.*;

public class Main {
    static boolean[] isNotPrime;
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(
            new InputStreamReader(System.in)).readLine().trim());
            
        isNotPrime = new boolean[N + 1];
        sieve(N);
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }
        int start = 0, end = 0, sum = 0, count = 0;
        
        while (true) {
            if (sum >= N) {
                if (sum == N) count++;
                sum -= primes.get(start++);
            } else if (end == primes.size()) {
                break;
            } else {
                sum += primes.get(end++);
            }
        }
        System.out.println(count);
    }
    
    private static void sieve(int n) {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}