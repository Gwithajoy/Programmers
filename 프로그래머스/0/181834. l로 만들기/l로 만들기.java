class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder(myString.length());
        
        for (char ch: myString.toCharArray()) {
            sb.append(ch < 'l' ? 'l': ch);
        }

        return sb.toString();
    }
}
