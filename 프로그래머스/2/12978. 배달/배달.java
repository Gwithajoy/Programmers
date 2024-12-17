import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    static class Node {
        int to;
        int arrTime;
        
        Node(int to, int arrTime){
            this.to = to;
            this.arrTime = arrTime;
        }
    }
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < road.length; i++) {
            graph.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            graph.get(road[i][1]).add(new Node(road[i][0], road[i][2])); 

        }
        
        int[] dist = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        int start = 1;
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.arrTime - y.arrTime);
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
        
        
            if (curNode.arrTime > dist[curNode.to]) {
                continue;
            }
        
        for (int i = 0; i < graph.get(curNode.to).size(); i++) {
            Node adjNode = graph.get(curNode.to).get(i);
            
            if (dist[adjNode.to] > curNode.arrTime + adjNode.arrTime) {
                dist[adjNode.to] = curNode.arrTime + adjNode.arrTime;
                pq.offer(new Node(adjNode.to, dist[adjNode.to]));
            }
        }
    } 
         int reachable = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                reachable++;
            }
        }

        return reachable;
    }
}