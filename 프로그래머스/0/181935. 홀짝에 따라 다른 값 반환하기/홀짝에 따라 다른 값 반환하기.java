class Solution {
    public int solution(int n) {
        int answer = 0;
        int odd = 0;
        int even = 0;
        for (int i= 1; i <= n; i++) {
            if (i % 2 != 0) {
                odd += i;
            } else {
                even += Math.pow(i, 2);
            }
        }
        if (n%2.!= 0){
            answer = odd;
        } else {
            answer = even;
        }
        return answer;
    }
}