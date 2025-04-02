import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        
        boolean[]rowGuard = new boolean[N];
        boolean[]colGuard = new boolean[M];

        char[][] castle = new char[N][M];
        for (int i = 0; i < N; i++){
            String line = sc.nextLine();
            castle[i] = line.toCharArray();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(castle[i][j] == 'X'){
                    rowGuard[i] = true;
                    colGuard[j] = true;
                }
            }
        }
        
        int noGuardRow = 0;
        for (boolean yesGuard : rowGuard){
            if (!yesGuard) {
                noGuardRow++;
            }
        }
        
        int noGuardCol = 0;
        for(boolean yesGuard : colGuard) {
            if (!yesGuard) {
                noGuardCol++;
            }
        }
        
        System.out.println(Math.max(noGuardRow, noGuardCol));
        sc.close();
    }
}