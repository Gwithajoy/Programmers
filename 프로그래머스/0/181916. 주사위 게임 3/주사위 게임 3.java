import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] dice = {a, b, c, d};
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : dice) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        int score = 0;
        if (countMap.size() == 1) {
            int p = dice[0];
            score = 1111 * p;
        } else if (countMap.size() == 2) {
            List<Integer> keys = new ArrayList<>(countMap.keySet());
            int firstCount = countMap.get(keys.get(0));
            int secondCount = countMap.get(keys.get(1));
            
            if (firstCount == 3 || secondCount == 3) {
                int p = (firstCount == 3) ? keys.get(0) : keys.get(1);
                int q = (firstCount == 3) ? keys.get(1) : keys.get(0);
                score = (int) Math.pow((10 * p + q), 2);
            } else {
                int p = keys.get(0);
                int q = keys.get(1);
                score = (p + q) * Math.abs(p - q);
            }
        } else if (countMap.size() == 3) {

            int pair = 0;
            List<Integer> singles = new ArrayList<>();
            for (int key : countMap.keySet()) {
                if (countMap.get(key) == 2) {
                    pair = key;
                } else {
                    singles.add(key);
                }
            }
            score = singles.get(0) * singles.get(1);
        } else if (countMap.size() == 4) {
            int min = Integer.MAX_VALUE;
            for (int num : dice) {
                min = Math.min(min, num);
            }
            score = min;
        }
        
        return score;
    }
}
