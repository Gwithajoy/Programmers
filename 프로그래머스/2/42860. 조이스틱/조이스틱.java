class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = name.charAt(i);
            answer += Math.min(ch - 'A', 'Z' - ch + 1);
        }
        
        int minMove = n - 1;
        
        for (int i = 0; i < n; i++) {
            int next = i + 1;
           
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            
            int moveCase1 = 2 * i + n - next;
            int moveCase2 = i + 2 * (n - next);
            
            minMove = Math.min(minMove, Math.min(moveCase1, moveCase2));
        }
        
        answer += minMove;
        return answer;
    }
}
