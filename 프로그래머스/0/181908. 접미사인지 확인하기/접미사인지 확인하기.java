class Solution {
    public int solution(String my_string, String is_suffix) {
        int suffLeng = is_suffix.length();

        if (suffLeng > my_string.length()) {
            return 0;
        }

        String chk = my_string.substring(my_string.length() - suffLeng);
        if (chk.equals(is_suffix)) {
            return 1;
        }

        return 0;
    }
}
