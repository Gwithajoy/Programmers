import java.util.*;
import java.io.*;

public class Main {
    static class Student {
        String name;
        int korean, english, math;
        
        Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, korean, english, math));
        }
        list.sort((s1, s2) -> {
            if (s1.korean != s2.korean) return s2.korean - s1.korean;
            if (s1.english != s2.english) return s1.english - s2.english;
            if (s1.math != s2.math) return s2.math - s1.math;
            return s1.name.compareTo(s2.name);
        });
        StringBuilder sb = new StringBuilder();
        for (Student s : list) sb.append(s.name).append('\n');
        System.out.print(sb);
    }
}