class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계 -> 대괄호 안에 있는 기호와 소문자 숫자 제외 모두 불가
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
    
        // 3단계 -> .이 연달아서 2개 이상인 경우 하나로
        new_id = new_id.replaceAll("[.]{2,}", ".");
        
        // 4단계 -> 시작이 .이거나 끝이 .인 경우
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        
        // 5단계 -> 빈 문자열일 경우 a
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        
        // 6단계 -> 15자까지만 놔두고 나머지 삭제. 단, .으로 끝나면 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }
        
        // 7단계-> 아이디 길이가 최소 3글자가 될때까지 마지막 문자 붙이기
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        
        return new_id;
    }
}
