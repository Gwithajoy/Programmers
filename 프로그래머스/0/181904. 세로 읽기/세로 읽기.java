class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder answer = new StringBuilder();
        char[] arr = my_string.toCharArray();

        for (int i = 0; i < arr.length; i += m) {
            answer.append(arr[i + c - 1]);
        }

        return answer.toString();
    }
}


