package Graph;

import java.util.*; // Includes ArrayList, HashMap, Queue, LinkedList, etc.

public class BFSTravers {

     // Helper method to add edges
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
       
    }

    // BFS traversal from a given source node
    static ArrayList<String> BFS(ArrayList<ArrayList<Integer>> adj, Map<Integer, String> indexToVertex) {
        int V = adj.size(); // Number of vertices

        int s = 0; // Source node 

        // store the order of traversal in terms of vertex names
        ArrayList<String> result = new ArrayList<>();

        // Queue to manage the BFS traversal
        Queue<Integer> q = new LinkedList<>();

        // Track which vertices have been visited
        boolean[] visited = new boolean[V];

        // Start from source node: mark as visited and enqueue
        visited[s] = true;
        q.add(s);
        // BFS loop
        while (!q.isEmpty()) {
            int curr = q.poll(); // Dequeue
            System.out.println("current pull : " + indexToVertex.get(curr));
            // System.out.println("indexes stored in Q: " + q);

            result.add(indexToVertex.get(curr)); // Add to result

            // Traverse all unvisited neighbors of current node
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                     System.out.println("neighbor : " + indexToVertex.get(neighbor));
                    System.out.println("indexes stored in Q: " + q);


                }
            }
        }
        return result;
    }

   

    public static void main(String[] args) {
        String[] vertex = {"V1", "V2", "V3", "V4", "V5", "V6"};
        int V = vertex.length;

        // Maps for converting between names and indices
        Map<String, Integer> vertexIndexMap = new HashMap<>();
        Map<Integer, String> indexToVertex = new HashMap<>();

        for (int i = 0; i < V; i++) {
            vertexIndexMap.put(vertex[i], i);
            indexToVertex.put(i, vertex[i]);
        }

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Edges of the graph
        String[][] edges = {
            {"V1", "V2"}, {"V1", "V4"}, {"V2", "V3"}, {"V2", "V6"},
            {"V3", "V5"}, {"V3", "V6"}, {"V4", "V3"}, {"V4", "V5"}
        };

        // Convert string edges to index and add to adjacency list
        for (String[] edge : edges) {
            int u = vertexIndexMap.get(edge[0]);
            int v = vertexIndexMap.get(edge[1]);
            addEdge(adj, u, v);
        }

        // Perform BFS traversal and print result
        ArrayList<String> result = BFS(adj, indexToVertex);
        System.out.println();
        System.out.println("BFS Traversal: " + result);
        System.out.println();
    }
}
