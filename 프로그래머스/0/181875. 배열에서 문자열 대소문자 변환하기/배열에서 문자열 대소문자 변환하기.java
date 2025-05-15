import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < strArr.length; i++) {
            if (i % 2 == 0) {
                String b = strArr[i].toLowerCase();
                answer.add(b);
            } else {
                String a = strArr[i].toUpperCase();
                answer.add(a);
            }
        }
        
        return answer.toArray(new String[0]);
    }
}

