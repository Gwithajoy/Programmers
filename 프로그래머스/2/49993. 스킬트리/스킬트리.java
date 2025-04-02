class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;

        for (String tree : skill_trees) {
            int idx = 0; 
            boolean isValid = true;

            for (char treeChar : tree.toCharArray()) {
                int position = skill.indexOf(treeChar); 
                if (position== -1) {
                    continue;     
                }
                if (position == idx) {
                    idx++; 
                } else {
                    isValid = false; 
                    break;
                }
            }

            if (isValid) count++;
        }
        return count;
    }
}
