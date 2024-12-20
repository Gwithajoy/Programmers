class Solution {
    public String solution(String number, int k) {
        StringBuilder stack = new StringBuilder();
        int removed = 0;

        for (char digit : number.toCharArray()) {
            while (stack.length() > 0 && stack.charAt(stack.length() - 1) < digit && removed < k) {
                stack.deleteCharAt(stack.length() - 1);
                removed++;
            }
            stack.append(digit);
        }

        while (removed < k) {
            stack.deleteCharAt(stack.length() - 1);
            removed++;
        }

        return stack.toString();
    }
}


