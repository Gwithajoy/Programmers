import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            String cityLow = city.toLowerCase();
            if (cache.contains(cityLow)) {
                cache.remove(cityLow);
                cache.add(cityLow);
                answer += 1;
            } else {
                answer += 5;
                if (cacheSize > 0) {
                    if (cache.size() == cacheSize) {
                        cache.removeFirst();
                    }
                    cache.add(cityLow);
                }
            }
        }
        return answer;
    }
}
