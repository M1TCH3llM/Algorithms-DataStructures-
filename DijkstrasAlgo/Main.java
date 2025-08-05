package DijkstrasAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
   
    // Dijkstra algorithm implementation
    static int[] dijkstra(int V, int[][] edges, int src) {

        // Build the adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = constructAdj(edges, V);

        // Distance array initialized with "infinity"
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // Distance to self is 0
        // System.out.println("Distance  " + dist);


        // PriorityQueue to always pick node with shortest distance
        PriorityQueue<ArrayList<Integer>> pq = 
            new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));

        // Add the source node to the queue
        pq.offer(new ArrayList<>(Arrays.asList(0, src))); // [distance, node]

        // Process the queue
        while (!pq.isEmpty()) {
            ArrayList<Integer> curr = pq.poll();
            int u = curr.get(1); // current node

            // Visit all neighbors of current node
            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);    // neighbor node
                int weight = neighbor.get(1); // edge weight

                // Relaxation step: check if new path is shorter
                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;

                    // Push updated path into the queue
                    pq.offer(new ArrayList<>(Arrays.asList(dist[v], v)));
                }
            }
        }

        return dist;
    }

    // Helper method to build adjacency list
    static ArrayList<ArrayList<ArrayList<Integer>>> constructAdj(int[][] edges, int V) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Initialize adjacency list with empty lists
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add all edges & distance
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            adj.get(u).add(new ArrayList<>(Arrays.asList(v, weight))); 
        }

        System.out.println("adjacency list " + adj);
        return adj;
    }

     public static void main(String[] args) {
        int V = 6; // Number of vertices: v1 to v6

        // Each edge is: {source, destination, weight}
        int[][] edges = {
            {0, 1, 5},  // v1 -> v2
            {0, 3, 3},  // v1 -> v4
            {1, 2, 4},  // v2 -> v3
            {1, 5, 6},  // v2 -> v6
            {2, 4, 3},  // v3 -> v5
            {2, 5, 3},  // v3 -> v6
            {3, 2, 2},  // v4 -> v3
            {3, 4, 6}   // v4 -> v5
        };

        int src = 0; // Starting from v1 (index 0)

        int[] dist = dijkstra(V, edges, src);

        // Output distances from source
        System.out.println("Shortest distances from v1:");
        for (int i = 0; i < V; i++) {
            System.out.println("v" + (src + 1) + " to v" + (i + 1) + " = " + dist[i]);
        }
    }
}
