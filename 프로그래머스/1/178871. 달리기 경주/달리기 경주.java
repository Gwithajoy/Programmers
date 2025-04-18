import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerIndexMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndexMap.put(players[i], i);
        }

        for (String calling : callings) {
            int currentIndex = playerIndexMap.get(calling);
            if (currentIndex > 0) { 
                String frontPlayer = players[currentIndex - 1];

                players[currentIndex - 1] = calling;
                players[currentIndex] = frontPlayer;

                playerIndexMap.put(calling, currentIndex - 1);
                playerIndexMap.put(frontPlayer, currentIndex);
            }
        }

        return players;
    }
}
