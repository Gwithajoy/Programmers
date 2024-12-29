import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack stack = new Stack();
        
        for (String str : s.split("")) {
            if (str.equals("(")) {
                stack.push(str);
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty() && answer){
            answer = true;

        } else {
            answer = false;

        }
       return answer;
    }
}