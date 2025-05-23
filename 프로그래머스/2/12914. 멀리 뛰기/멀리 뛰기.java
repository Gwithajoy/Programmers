class Solution {
    public long solution(int n) {
        long answer = 0;
        if (n == 1 ) {
            return 1;
        }
        
        int divide = 1234567;
        long[] dp = new long[n+1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i =3; i <=n ; i++) {
            dp[i] = (dp[i-1]+dp[i-2]) % divide;
        
        }
        answer = dp[n];
        
        return answer;
        
        
    }
}