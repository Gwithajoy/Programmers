class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);

        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];

            while (s < e) {
                char temp = sb.charAt(s);
                sb.setCharAt(s, sb.charAt(e));
                sb.setCharAt(e, temp);
                s++;
                e--;
            }
        }

        return sb.toString();
    }
}
