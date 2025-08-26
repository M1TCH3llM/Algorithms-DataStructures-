package FinalAssessment;

public class Circle {
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
        Circle sol = new Circle();

        int[] A0 = {1, 3, 2, 4};
        int[] B0 = {4, 1, 3, 2};

        boolean ans = sol.solution(A0, B0);
        System.out.println("Is graph 0 a circle?: " +  ans);

        int[] A1 = {3, 1, 2};
        int[] B1 = {2, 3, 1};

        boolean ans1 = sol.solution(A1, B1);
        System.out.println("Is graph 1 a circle?: " +  ans1);

        int[] A2 = {1, 2, 1};
        int[] B2 = {2, 3, 3};

        boolean ans2 = sol.solution(A2, B2);
        System.out.println("Is graph 2 a circle?: " +  ans2);

        int[] A3 = {1, 2, 3, 4};
        int[] B3 = {2, 1, 4, 4};

        boolean ans3 = sol.solution(A3, B3);
        System.out.println("Is graph 3 a circle?: " +  ans3);

    }
}


