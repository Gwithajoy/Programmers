import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < intStrs.length; i++) {
            String strNum = intStrs[i].substring(s, s + l);
            int num = Integer.parseInt(strNum);

            if (num > k) {
                list.add(num);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
