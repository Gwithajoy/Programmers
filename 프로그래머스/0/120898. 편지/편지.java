class Solution {
    public int solution(String message) {
        int answer = 0;
        char[] toChar = message.toCharArray();
        answer = toChar.length * 2;
        return answer;
    }
}