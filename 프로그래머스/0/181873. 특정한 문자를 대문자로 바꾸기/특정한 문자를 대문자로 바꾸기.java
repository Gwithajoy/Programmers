class Solution {
    public String solution(String my_string, String alp) {
        char newAlp = alp.charAt(0);
        char upperAlp = Character.toUpperCase(newAlp);
        
        return my_string.replace(newAlp, upperAlp);
    }
}