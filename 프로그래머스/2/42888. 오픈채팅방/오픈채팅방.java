import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> uidNickname = new HashMap<>();
        List<String> motion = new ArrayList<>();
        
        for (String rec : record) {
            String[] parts = rec.split(" ");
            String command = parts[0];
            String uid = parts[1];
            String nickname = "";
            if (!command.equals("Leave")) {
                nickname = parts[2];
            }
      
            if (command.equals("Enter")) {
                uidNickname.put(uid, nickname);
                motion.add(uid + " Enter");
            } else if (command.equals("Leave")) {
                motion.add(uid + " Leave");
            } else if (command.equals("Change")) {
                uidNickname.put(uid, nickname);
            }
        }
        
        String[] answer = new String[motion.size()];
        int idx = 0;
        
        for (String act : motion) {
            String[] tokens = act.split(" ");
            String uid = tokens[0];
            String actType = tokens[1];
            if (actType.equals("Enter")) {
                answer[idx++] = uidNickname.get(uid) + "님이 들어왔습니다.";
            } else {
                answer[idx++] = uidNickname.get(uid) + "님이 나갔습니다.";
            }
        }
        
    
        return answer;
    }
}
