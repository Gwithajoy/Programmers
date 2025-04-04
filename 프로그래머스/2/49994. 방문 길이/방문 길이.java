import java.util.HashSet; 

class Solution {
    public int solution(String dirs){
        int x = 0;
        int y = 0;

        HashSet<String> visited = new HashSet<>();

        for (char move : dirs.toCharArray()) {
            int nx = x;
            int ny = y;

            switch (move) {
                case 'U': ny++; break;
                case 'D': ny--; break;
                case 'R': nx++; break;
                case 'L': nx--; break;
            }

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            String road = Math.min(x, nx) + "," 
                        + Math.min(y, ny) + "," 
                        + Math.max(x, nx) + "," 
                        + Math.max(y, ny);
            
            visited.add(road);
            x = nx;
            y = ny;
        }

        
        return visited.size();
    }
}