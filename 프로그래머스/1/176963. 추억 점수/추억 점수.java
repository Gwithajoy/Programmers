
import java.util.HashMap;
import java.util.Map;


class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> memoryMap = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            memoryMap.put(name[i], yearning[i]);
        }
 
        int[] answer = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            int memoryScore = 0;
            for (String person : photo[i]) {
                memoryScore += memoryMap.getOrDefault(person, 0);
            }
            answer[i] = memoryScore;
        }

        return answer;
    }
}
