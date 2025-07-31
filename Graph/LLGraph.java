package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LLGraph {
    static void addEdge(LinkedList<LinkedList<Integer>> Adj, int u, int v) 
    {
        Adj.get(u).add(v);
        
    }


            // Print List
    static void printAdjList(LinkedList<LinkedList<Integer>> adj, Map<Integer, String> indexToVertex) {
         for (int i = 0; i < adj.size(); ++i) {
            if (!adj.get(i).isEmpty()) {
                System.out.print(indexToVertex.get(i) + " -> ");
                for (int j = 0; j < adj.get(i).size(); j++) {
                    System.out.print(indexToVertex.get(adj.get(i).get(j)));
                    if (j < adj.get(i).size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args)
    {
        // Creating vertex
        String[] vertex = {"V1", "V2", "V3", "V4", "V5", "V6"};

        int V = vertex.length;

        Map<String, Integer> vertexIndexMap = new HashMap<>();
        Map<Integer, String> indexToVertex = new HashMap<>();
        for (int i = 0; i < V; i++) {
            vertexIndexMap.put(vertex[i], i);
            indexToVertex.put(i, vertex[i]);
        }

        // Initialize adjacency list
        LinkedList<LinkedList<Integer>> adj = new LinkedList<>();
        for (int i = 0; i < V; ++i) {
            adj.add(new LinkedList<>());
        }

        // Define edges
        String[][] edges = {{"V1", "V2"}, {"V1", "V4"}, {"V2", "V3"}, {"V2", "V6"}, {"V3", "V5"}, {"V3", "V6"}, {"V4", "V3"}, {"V4", "V5"}};

        // Add edges
        for (String[] edge : edges) {
            int u = vertexIndexMap.get(edge[0]);
            int v = vertexIndexMap.get(edge[1]);
            addEdge(adj, u, v);
        }


        // Printing adjacency List
        printAdjList(adj, indexToVertex);
    }
}


// String[] vertex = {"V1", "V2", "V3", "V4", "V5", "V6"};
// String[][] edges = {{"V1","V2"}, {"V1","V4"},{"V2","V3"}, {"V2","V6"}, {"V3","V5"}, {"V3","V6"}, {"V4","V3"}, {"V4","V5"}};
