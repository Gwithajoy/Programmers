import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < num_list.length; i++) {
            if (i >= n - 1) {
                answer.add(num_list[i]);
            } 
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}