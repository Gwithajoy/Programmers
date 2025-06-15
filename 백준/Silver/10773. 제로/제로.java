import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num == 0 && list.size() != 0) {
                list.remove(list.size()-1);
            } else {
                list.add(num);
            }
        }
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}