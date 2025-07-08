import java.io.*;
import java.util.*;

public class Main {
    static class Member {
        int age;
        String name;
        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Member> members = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(age, name));
        }
        Collections.sort(members, Comparator.comparingInt(m -> m.age));
        StringBuilder sb = new StringBuilder();
        
        for(Member m : members) {
            sb.append(m.age)
                .append(' ')
                .append(m.name)
                .append('\n');
        }
        System.out.print(sb);
    }
}