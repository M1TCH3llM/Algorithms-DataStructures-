package Problems;

public class TwentyEight {
    public boolean solution (int[] A, int[] B) {
        int n = A.length;

        // Track the direction of in and out edges
        int[] inEdge = new int[n+1];
        int[] outEdge = new int[n+1];

        for (int i = 0; i < n ; i++) {
            outEdge[A[i]]++;
            inEdge[B[i]]++;
        }

        // Validate that each vertex has in and out edge
        for (int v = 1; v <= n; v++) {
            if(inEdge[v] != 1 || outEdge[v] != 1) {
                return false;
            }
        }

        // Check connectivity 
        boolean[] visited = new boolean[n+1];
        int start = A[0];
        int count = 0;
        int curr = start;

        do {
            visited[curr] = true;
            count ++;

            int next = -1;
            for (int i = 0; i < n; i ++) {
                if (A[i] == curr) {
                    next = B[i];
                    break;
                }
            }
            curr = next;
        } while (curr != start && !visited[curr]);

        return (count == n && curr == start);

    }

    public void main(String[] args) {
        TwentyEight array = new TwentyEight();

    }
}
