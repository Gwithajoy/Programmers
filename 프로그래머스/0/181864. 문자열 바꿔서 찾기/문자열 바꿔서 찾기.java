class Solution {
    public int solution(String myString, String pat) {
        String newString = myString.replace("A", "b").replace("B", "a").toUpperCase();
        return newString.contains(pat) ? 1 : 0;
        
        
    }
}