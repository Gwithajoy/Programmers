import java.util.*;

public class Solution {
    public int solution(int n, int[][] vertex) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : vertex) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] distances = new int[n + 1]; 
        Arrays.fill(distances, -1); 
        
        queue.offer(1);
        distances[1] = 0; 
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) { 
                    distances[neighbor] = distances[current] + 1; 
                    queue.offer(neighbor);
                }
            }
        }
        
        int maxDistance = 0;
        int count = 0;
        for (int distance : distances) {
            if (distance > maxDistance) {
                maxDistance = distance;
                count = 1;
            } else if (distance == maxDistance) {
                count++; 
            }
        }
        
        return count;
    }
}
