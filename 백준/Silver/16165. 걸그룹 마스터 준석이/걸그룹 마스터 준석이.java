import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, List<String>> teamToMembers = new HashMap<>();
        Map<String, String> memberToTeam = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String teamName = br.readLine(); 
            int memberCount = Integer.parseInt(br.readLine());

            List<String> members = new ArrayList<>();
            for (int j = 0; j < memberCount; j++) {
                String member = br.readLine();
                members.add(member);
                memberToTeam.put(member, teamName);
            }

            Collections.sort(members);
            teamToMembers.put(teamName, members);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String quizName = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if (type == 0) {
                for (String member : teamToMembers.get(quizName)) {
                    sb.append(member).append("\n");
                }
            } else {
                sb.append(memberToTeam.get(quizName)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
