import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int[] chkLine = new int[26];

        for (char c : S.toCharArray()) {
            chkLine[c - 'a']++;
        }

        for (int num : chkLine) {
            System.out.print(num + " ");
        }
    }
}
