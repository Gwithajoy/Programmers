import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;

        if (num_list.length >= 11) {
            answer = IntStream.range(0, num_list.length)
                              .map(i -> num_list[i])
                              .sum();
        } else {
            answer = IntStream.range(0, num_list.length)
                               .map(i -> num_list[i])
                               .reduce(1, (a, b) -> a * b);
        }

        return answer;
    }
}


