import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0; 
        int lastPainted = 0; 
        
        for (int current : section) {
            if (current > lastPainted) { 
                answer++; 
                lastPainted = current + m - 1; 
            }
        }
        
        return answer; 
    }
}
