import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> list = new ArrayList<>();

        for (int item : array) {
            list.add(item);
        }

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int num = commands[i][2];

            // 수정된 부분
            List<Integer> list2 = list.subList(start - 1, end); 
            List<Integer> sortedList = new ArrayList<>(list2); 
            sortedList.sort(Comparator.naturalOrder()); 

            answer[i] = sortedList.get(num - 1); 
            
        }

        return answer;
    }
}
