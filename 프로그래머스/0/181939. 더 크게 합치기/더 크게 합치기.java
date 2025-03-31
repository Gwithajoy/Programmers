class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String sa = Integer.toString(a);
        String sb = Integer.toString(b);
        
        int num1 = Integer.parseInt(sa + sb);
        int num2 = Integer.parseInt(sb + sa);
        
        if (num1 > num2) {
            answer = num1;
        } else{
            answer = num2;
        }
        return answer;
    }
}