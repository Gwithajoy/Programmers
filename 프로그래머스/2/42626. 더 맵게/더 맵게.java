import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : scoville) {
            pq.offer(num);
        }
        
        if (pq.peek() >= K) {
            return answer;
        }
        
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int newScoville = first + (second * 2);
            pq.offer(newScoville);
            answer++;

            if (pq.peek() >= K) {
                return answer;
            }
        }
        
        return pq.peek() >= K ? answer : -1;
    }
}