class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        // 모든 문자를 소문자로 변환한 뒤 split하지 않고 순차 처리
        boolean isStartOfWord = true;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                // 공백은 그대로 추가
                answer.append(c);
                isStartOfWord = true;
            } else if (isStartOfWord) {
                // 단어의 첫 문자라면 대문자로 변환
                answer.append(Character.toUpperCase(c));
                isStartOfWord = false;
            } else {
                // 나머지 문자는 소문자로 변환
                answer.append(Character.toLowerCase(c));
            }
        }
        
        return answer.toString();
    }
}
