/**
 * [문제 핵심]
 * - 주어진 폰켓몬 배열 nums에서 총 길이가 N인 배열 중 N/2 마리를 선택한다.
 * - 같은 종류의 폰켓몬은 같은 번호를 가진다.
 * - 가능한 한 "많은 종류"의 폰켓몬을 포함하여 N/2마리를 골랐을 때,
 *   그 "종류의 개수" 최댓값을 구해야 한다.
 *
 * [핵심 아이디어]
 * 1) N/2마리만 선택 가능.
 * 2) 중복을 제거했을 때의 "서로 다른 폰켓몬 종류의 수"를 구한다.
 * 3) 실제로 뽑을 수 있는 폰켓몬 종류 수의 최댓값은
 *      min(서로 다른 폰켓몬 종류의 수, N/2)
 *    이유:
 *      - 아무리 중복이 많아도, 종류 수를 최대화하려면
 *        각 종류를 최대 1마리씩만 선택해야 함.
 *      - 하지만 N/2마리를 초과해서 더 많은 종류를 고를 수는 없다.
 *        (예: 종류가 5가지여도, 뽑을 수 있는 수가 3마리라면 최대 3종류만 가능)
 *
 * [조건 / 제한 사항]
 * - nums.length = N (짝수, 1 <= N <= 10,000)
 * - 폰켓몬 번호 범위: 1 ~ 200,000
 *
 * [예상 시간복잡도]
 * - 중복 제거 (HashSet) 사용 시 O(N)
 * - 이후 계산은 O(1)
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        // 1) 서로 다른 폰켓몬 종류 수를 구한다.
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int distinctCount = set.size();

        // 2) 최대 선택 가능 수 (N/2)와 distinctCount 중 작은 값이 답
        return Math.min(distinctCount, n / 2);
    }
}
