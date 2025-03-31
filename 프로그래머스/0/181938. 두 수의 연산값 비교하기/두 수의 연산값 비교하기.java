class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int num1 = a * (int)Math.pow(10, digits(b)) + b;
        int num2 = 2 * a * b;
        
        if (num1 >= num2) {
            answer = num1;
        } else{
            answer = num2;
        }
        return answer;
    }
    
    private int digits(int n) {
        if (n == 0) return 1;
        int count = 0; 
        
        while (n > 0) {
            count += 1;
            n /= 10;
        }
        return count;
    }
}