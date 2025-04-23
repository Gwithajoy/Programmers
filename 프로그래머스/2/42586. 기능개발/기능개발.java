import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length; // 작업의 개수 
        
        // 각 작업이 완료되기까지 남은 '일 수'를 저장할 배열
        int[] days = new int[n];
        
        // 각 작업에 대해 완료까지 걸리는 일 수 계산
        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i]; // 남은 진행도 계산
            days[i] = (remain + speeds[i] - 1) / speeds[i];            
        }
        
        // 결과를 담을 리스트 (각 배포에 몇 개의 기능이 포함되는지 저장)
        List<Integer> result = new ArrayList<>();
        
        // 첫 작업의 완료 일수를 기준으로 삼고, 첫 작업은 무조건 배포되므로 count = 1
        int currentMax = days[0];
        int count = 1;

        // 두 번째 작업부터 순회하면서 배포 묶음을 계산
        for (int i = 1; i < n; i++) {
            if (days[i] <= currentMax) {
                // 현재 배포 기준일(currentMax)보다 빨리 끝났으면 같은 배포에 포함
                count++;
            } else {
                // 앞의 배포와 같이 묶을 수 없으므로 지금까지의 count 저장
                result.add(count);
                // 새 기준일 갱신하고 count도 초기화
                currentMax = days[i];
                count = 1;
            }
        }
        
        // 마지막 배포 묶음 추가(반복문 끝나고 남은 count)
        result.add(count);
        
        // List<Integer> -> int[]로 변환해서 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
    