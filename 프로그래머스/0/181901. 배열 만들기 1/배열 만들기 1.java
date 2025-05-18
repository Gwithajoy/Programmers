import java.util.stream.*;

class Solution {
    public int[] solution(int n, int k) {
        return IntStream.iterate(k, i -> i <= n, i -> i + k).toArray();
        
    }
}