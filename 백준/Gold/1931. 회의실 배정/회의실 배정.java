import java.io.*;
import java.util.*;

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start, end;
        Meeting(int s, int e) { start = s; end = e; }
        @Override
        public int compareTo(Meeting o) {
            if (this.end != o.end) 
                return Integer.compare(this.end, o.end);
            return Integer.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            meetings[i] = new Meeting(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
        }

        Arrays.sort(meetings);

        int count = 0;
        int lastEnd = -1;  
        for (Meeting m : meetings) {
            if (m.start >= lastEnd) {
                count++;
                lastEnd = m.end;
            }
        }

        System.out.println(count);
    }
}
