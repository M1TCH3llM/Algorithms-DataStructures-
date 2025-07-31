package Graph;

import java.util.*;

public class DFSTravers {

    // adds edges
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        
    }

    public static ArrayList<String> DFS(ArrayList<ArrayList<Integer>> adj, Map<Integer, String> indexToVertex) {
        boolean[] visited = new boolean[adj.size()];  // Tracks Visited nodes
        ArrayList<String> result = new ArrayList<>(); // store order of visited vertex's

        // loops through all nodes
        for (int start = 0; start < adj.size(); start++) {
            if (!visited[start]) {
                Stack<Integer> stack = new Stack<>(); // Stack for DFS Traversal 
                stack.push(start); // index 0 

                 

                // while stack is not empty            
                while (!stack.isEmpty()) {
                    int node = stack.pop(); // takes last pushed node
                    System.out.println("pop " + indexToVertex.get(node));

                    // if not visited 
                    if (!visited[node]) {
                        visited[node] = true; // mark as visited
                        result.add(indexToVertex.get(node)); // add to result
                        System.out.println("added to order: " + indexToVertex.get(node)); 

                        // Add neighbors in reverse order to match recursive DFS order
                        List<Integer> neighbors = adj.get(node);
                        System.out.println("neighbor indexes: " + neighbors);
                       
                        // 
                        for (int neighbor : neighbors) {
                            if (!visited[neighbor]) {
                                
                                stack.push(neighbor);
                        System.out.println("neighbor pushed: " + indexToVertex.get(neighbor));


                            }
                        }
                        
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] vertex = {"V1", "V2", "V3", "V4", "V5", "V6"};
        int V = vertex.length;

        // create maps to story vertexes and their index
        Map<String, Integer> vertexIndexMap = new HashMap<>();
        Map<Integer, String> indexToVertex = new HashMap<>();

        // map for easy conversion 
        for (int i = 0; i < V; i++) {
            vertexIndexMap.put(vertex[i], i);
            indexToVertex.put(i, vertex[i]);
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        String[][] edges = {
            {"V1", "V2"}, {"V1", "V4"}, {"V2", "V3"}, {"V2", "V6"},
            {"V3", "V5"}, {"V3", "V6"}, {"V4", "V3"}, {"V4", "V5"}
        };

        for (String[] edge : edges) {
            int u = vertexIndexMap.get(edge[0]);
            int v = vertexIndexMap.get(edge[1]);
            addEdge(adj, u, v);
        }

        ArrayList<String> result = DFS(adj, indexToVertex);
        System.out.println(" ");
        System.out.println("DFS Traversal: " + result);
        System.out.println(" ");

    }
}
