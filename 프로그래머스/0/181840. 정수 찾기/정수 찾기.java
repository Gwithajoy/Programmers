import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        boolean isTrue = Arrays.stream(num_list).anyMatch(x -> x == n);
        return isTrue ? 1 : 0;
    }
}

