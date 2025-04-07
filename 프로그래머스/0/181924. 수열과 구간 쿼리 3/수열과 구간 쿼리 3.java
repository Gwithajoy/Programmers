class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        int tmp = 0;
        for (int idx = 0; idx < queries.length; idx++) {
            int i = queries[idx][0];
            int j =  queries[idx][1];
            
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
                    }
}