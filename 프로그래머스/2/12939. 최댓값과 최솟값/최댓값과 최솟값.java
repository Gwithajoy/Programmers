import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        
        for (String str : arr) {
            list.add(Integer.parseInt(str));
        }
        
        int max = Collections.max(list);
        int min = Collections.min(list);
        
        return min + " " + max;
    }
}
