import java.util.*;

class Solution {
    public int[] solution(String s) {
        String s1 = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] chunks = s1.split("-");
        List<List<Integer>> listOfSets = new ArrayList<>();
        for (String chunk : chunks) {
            List<Integer> set = new ArrayList<>();
            for (String num : chunk.split(",")) {
                set.add(Integer.parseInt(num));
            }
            listOfSets.add(set);
        }
        listOfSets.sort(Comparator.comparingInt(List::size));
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (List<Integer> set : listOfSets) {
            for (Integer num : set) {
                if (seen.add(num)) {
                    result.add(num);
                }
            }
        }
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
