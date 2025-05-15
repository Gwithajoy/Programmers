import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        return IntStream.concat(Arrays.stream(num_list, n , num_list.length), Arrays.stream(num_list, 0, n)).toArray();
    }
}
