import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String[] time = sc.nextLine().split(" ");

            int h1 = Integer.parseInt(time[0]);
            int m1 = Integer.parseInt(time[1]);
            int s1 = Integer.parseInt(time[2]);
            int h2 = Integer.parseInt(time[3]);
            int m2 = Integer.parseInt(time[4]);
            int s2 = Integer.parseInt(time[5]);

            int wh = h2 - h1;
            int wm = m2 - m1;
            int ws = s2 - s1;

            if (ws < 0) { 
                ws += 60; wm--; 
            }
            if (wm < 0) { 
                wm += 60; wh--;
            }

            System.out.println(wh + " " + wm + " " + ws);
        }

        sc.close();
    }
}
