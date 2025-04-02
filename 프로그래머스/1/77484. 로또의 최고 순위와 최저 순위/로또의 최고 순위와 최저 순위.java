class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int non = 0;   
        int match = 0;  

        for (int num : lottos) {
            if (num == 0) {
                non++;
            } else {
                for (int win : win_nums) {
                    if (num == win) {
                        match++;
                        break;
                    }
                }
            }
        }
        
        int bestCase = match + non;
        int worstCase = match;
        
        int best = getRank(bestCase);
        int worst = getRank(worstCase);
        
        return new int[]{best, worst};
    }
    
    public int getRank(int correct) {
        switch (correct) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}
