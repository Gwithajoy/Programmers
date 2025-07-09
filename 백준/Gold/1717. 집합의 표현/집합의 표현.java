import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int[] rank;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parent = new int[n+1];
        rank = new int[n+1];
        
        for (int i = 0;  i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (op == 0) {
                union(a, b);
            } else {
                sb.append(find(a) == find(b) ? "YES\n" : "NO\n");
            }
        }
        System.out.print(sb);
    }
        
        static void union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) return ;
            
            if (rank[ra] < rank[rb]) {
                parent[rb] = ra;
            } else if (rank[ra] > rank[rb]) {
                parent[rb] = ra;
            } else {
                parent[rb] = ra;
                rank[ra]++;
            }
        }
        

        static int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }   
    }