class Solution {
    public int[] solution(int[] arr, int k) {
        int[] result = new int[arr.length];
        boolean isEven = (k % 2 == 0);

        for (int i = 0; i < arr.length; i++) {
            result[i] = isEven
                ? arr[i] + k
                : arr[i] * k;
        }

        return result;
    }
}
