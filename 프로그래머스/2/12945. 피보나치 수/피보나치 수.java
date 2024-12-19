class Solution {
    public int solution(int n) {
        // 모듈러 연산 상수
        int MOD = 1234567;

        // 초기 조건
        if (n == 0) return 0;
        if (n == 1) return 1;

        // 반복문을 이용한 피보나치 계산
        int a = 0; // F(0)
        int b = 1; // F(1)
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = (a + b) % MOD; // F(n) = (F(n-1) + F(n-2)) % MOD
            a = b;                 // 이전 값을 앞으로 이동
            b = result;            // 현재 값을 앞으로 이동
        }

        return result;
    }
}
