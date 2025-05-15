import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < names.length; i += 5) {
            String[] chunk = Arrays.copyOfRange(names, i, Math.min(i + 5, names.length));
            answer.add(chunk[0]);
        }

        return answer.toArray(new String[0]);
    }
}
