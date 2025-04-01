class Solution {
    public String solution(String code) {
        int mode = 0;
        String ret = "";

        for (int idx = 0; idx < code.length(); idx++) {
            char letter = code.charAt(idx);        
            
            if (mode == 0) {
                if (letter == '1') {
                    mode = 1;
                } else if (idx % 2 == 0) {
                    ret += letter;
                }
            } else { // mode == 1
                if (letter == '1') {
                    mode = 0;
                } else if (idx % 2 != 0) {
                    ret += letter;
                }
            }
        }

        return ret.equals("") ? "EMPTY" : ret;
    }
}



