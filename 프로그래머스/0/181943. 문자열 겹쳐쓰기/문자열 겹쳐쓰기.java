class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder strb = new StringBuilder(my_string);
        strb.replace(s, s + overwrite_string.length(), overwrite_string);
        return strb.toString();
    }
}
