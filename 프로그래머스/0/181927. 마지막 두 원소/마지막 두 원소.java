class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        int lastNum = num_list[num_list.length - 1];
        int secondLast = num_list[num_list.length -2];
        int newValue ;
        
        if (lastNum > secondLast) {
           newValue = lastNum - secondLast;
        } else {
            newValue = lastNum * 2;
        }
        
        for (int i = 0; i < num_list.length; i++ ){
            answer[i] = num_list[i];
        }
        answer[answer.length - 1] = newValue;

        return answer;
    }
}

