import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        int order = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll(); 
            boolean maxPriority = false;
            
            for (int index : queue) {
                if (priorities[index] > priorities[current]) {
                    maxPriority = true;
                    break;
                }
            }
            
            if (maxPriority) {
                queue.offer(current);
                
            } else {
                order++;
                
                if (current == location) {
                    return order;
                }
            }
        }
        return order;
    }
}
