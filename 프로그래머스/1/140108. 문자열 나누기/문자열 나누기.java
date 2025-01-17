class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int countX = 0;      
        int countNotX = 0;   
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) {
                countX++;
            } else {
                countNotX++;
            }

            if (countX == countNotX) {
                answer++;
                countX = 0;
                countNotX = 0;

                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1);
                }
            }
        }
  
        if (countX != 0 || countNotX != 0) {
            answer++;
        }
        
        return answer;
    }
}
