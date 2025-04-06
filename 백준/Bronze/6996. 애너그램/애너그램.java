import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
        if (first.length() != second.length()) {
            return false;
        }
    
        char[] arrFirst = first.toCharArray();
        char[] arrSecond = second.toCharArray();
        
        Arrays.sort(arrFirst);
        Arrays.sort(arrSecond);
        
        return Arrays.equals(arrFirst, arrSecond);
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}
