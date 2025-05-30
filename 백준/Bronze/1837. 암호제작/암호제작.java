import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        BigInteger P = new BigInteger(in[0]);
        int K = Integer.parseInt(in[1]);

        for (int r = 2; r < K; r++) {
            if (P.mod(BigInteger.valueOf(r)).equals(BigInteger.ZERO)) {
                System.out.println("BAD " + r);
                return;
            }
        }
        System.out.println("GOOD");
    }
}
