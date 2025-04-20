import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        Map<String, Boolean> map = new HashMap<>();
        
        for (int i = 0; i < num; i++) {
            String[] log = sc.nextLine().split(" ");
            String name = log[0];
            String action = log[1];
            
            if (action.equals("enter")) {
                map.put(name, true);
            } else if (action.equals("leave")) {
                map.remove(name);
            }
        }
        
        map.keySet().stream()
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::println);
        sc.close();
    }
}