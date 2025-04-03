import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        String oddStr = "";
        String evenStr = "";
        
        for (int i = 0; i < num_list.length; i++) {
            String numStr = Integer.toString(num_list[i]);
            if (num_list[i] % 2 != 0) {
                oddStr += numStr;
            } else {
                evenStr += numStr;
            }
        }
        
        int odd = oddStr.equals("") ? 0 : Integer.parseInt(oddStr);
        int even = evenStr.equals("") ? 0 : Integer.parseInt(evenStr);
        
        return odd + even;
    }
}
