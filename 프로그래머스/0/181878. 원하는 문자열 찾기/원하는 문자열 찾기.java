class Solution {
    public int solution(String myString, String pat) {
        if (myString.length() < pat.length()) { return 0; }      
        return myString.toLowerCase().contains(pat.toLowerCase()) ? 1 : 0; 
    }
}