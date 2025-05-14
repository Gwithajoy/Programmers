class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        if (s == e) {return my_string;}
        
        char[] arr = my_string.toCharArray();
        
        while (s < e) {
            char tmp = arr[s];
            arr[s] = arr[e];
            arr[e] = tmp;
            s++;
            e--;
        }
        
        return new String(arr);
    }
}