import java.util.*;
import java.io.*;

public class Main {
    static class Member {
        int age;
        String name;
        int idx;
        
        Member(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        List<Member> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr.add(new Member(age, name, i));
        }
        arr.sort((s1, s2) -> {
            if (s1.age != s2.age) return s1.age - s2.age;
            return s1.idx - s2.idx;           
        });
        
        for (Member m : arr) {
            sb.append(m.age).append(" ").append(m.name).append('\n');
        }
        System.out.print(sb);
    }
}