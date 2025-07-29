package Graph;

import java.util.HashMap;
import java.util.Map;

public class AddEdge {
    public static void main(String[] args) {
        String[] vertices = {"V1", "V2", "V3", "V4", "V5", "V6"};
        String[][] edges = {{"V1","V2"}, {"V1","V4"},{"V2","V3"}, {"V2","V6"}, {"V3","V5"}, {"V3","V6"}, {"V4","V3"}, {"V4","V5"}};

        int n = vertices.length; // n = 6 in this instance
        int[] [] adjMatrix = new int [n] [n]; // create blank matrix
    
    //Map each vertex to its index 
    Map<String, Integer> vertexIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            vertexIndexMap.put(vertices[i], i); 
        }
    
        // Fill Matrix  
        // loops through array of edges 
        for (String[] edge : edges) {
            // identifies the from -> to ex. {V1, V2}
            String from = edge[0];
            String to = edge[1];
            
            // retrieves the information from the VIM and stores the condiments 
            int fromIndex = vertexIndexMap.get(from);
            int toIndex = vertexIndexMap.get(to);
            
            // updates the adjacency Matrix 
            adjMatrix[fromIndex][toIndex] = 1;
        }
         // Print the adjacency matrix
            System.out.print("    ");
            for (String vertex : vertices) {
                System.out.print(vertex + "  ");
            }
            System.out.println();
    
            for (int i = 0; i < n; i++) {
                System.out.print(vertices[i] + " ");
                for (int j = 0; j < n; j++) {
                    System.out.print("  " + adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
    };


}



// Add edge method to graph 

// String[] vertex = {"V1", "V2", "V3", "V4", "V5", "V6"};
// String[][] edges = {{"V1","V2"}, {"V1","V4"},{"V2","V3"}, {"V2","V6"}, {"V3","V5"}, {"V3","V6"}, {"V4","V3"}, {"V4","V5"}};