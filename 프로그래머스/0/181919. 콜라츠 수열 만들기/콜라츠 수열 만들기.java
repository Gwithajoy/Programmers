import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(n);
        for (int i = n; i >= 1; i--){
            if (n % 2 == 0) {
                n = n/2;
                answer.add(n);
                
            } else if (n!=1) {
                n = 3 * n +1;
                answer.add(n);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}

// 자연수 x -> 현재값 x 
// x가 짝수  / 2
// x 홀수 = 3*x+1
// -> 반복 언젠가 x =1