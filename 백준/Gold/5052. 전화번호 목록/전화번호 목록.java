import java.util.*;
import java.io.*;

public class Main {
    static class TrieNode {
        TrieNode[] child = new TrieNode[10];
        boolean isEnd = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            TrieNode root = new TrieNode();
            boolean consistent  = true;
            
            for (int i = 0; i < n; i++) {
                String phone = br.readLine().trim();
                if (consistent) {
                    if (!insert(root, phone)) {
                        consistent = false;
                    }
                }
            }
            sb.append(consistent ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
    static boolean insert(TrieNode root, String phone) {
        TrieNode node = root;
        for (char c : phone.toCharArray()) {
            int idx = c - '0';
            if (node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }
            node = node.child[idx];
            if (node.isEnd) {
                return false;
            }
        }
        for (int d = 0; d < 10; d++) {
            if (node.child[d] != null) {
                return false;
            }
        }
        node.isEnd = true;
        return true;
    
    }
}