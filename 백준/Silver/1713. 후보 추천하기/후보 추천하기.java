import java.io.*;
import java.util.*;

public class Main {
    static class Candidate {
        int id, count, time;
        Candidate(int id, int count, int time) {
            this.id = id;
            this.count = count;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int R = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Candidate> frames = new ArrayList<>(N);
        int t = 0;

        outer:
        for (int i = 0; i < R; i++) {
            int x = Integer.parseInt(st.nextToken());

            for (Candidate c : frames) {
                if (c.id == x) {
                    c.count++;
                    continue outer;
                }
            }

            if (frames.size() < N) {
                frames.add(new Candidate(x, 1, t++));
                continue;
            }

            Candidate toRemove = frames.get(0);
            for (Candidate c : frames) {
                if (c.count < toRemove.count ||
                    (c.count == toRemove.count && c.time < toRemove.time)) {
                    toRemove = c;
                }
            }
            frames.remove(toRemove);
            frames.add(new Candidate(x, 1, t++));
        }

        List<Integer> res = new ArrayList<>();
        for (Candidate c : frames) res.add(c.id);
        Collections.sort(res);

        StringBuilder sb = new StringBuilder();
        for (int id : res) {
            sb.append(id).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
