package Problems;


import java.util.ArrayDeque;

class Solution {

    // Directions for moving up, right, down, left
    private static final int[] DIR = {1, 0, -1, 0, 1}; 

    public int solution(int[][] A) {
        int n = A.length; // number of rows
        if (n == 0) return 0; // if empty matrix
        int m = A[0].length; // number of columns

        int best = 0; // size of largest connected component found

        // Try all consecutive digit pairs {k, k+1}
        for (int k = 0; k <= 8; k++) { // 
            boolean[][] vis = new boolean[n][m]; // marks as visited

            // Scan for potential starting points 
            for (int r = 0; r < n; r++) { // go over row
                for (int c = 0; c < m; c++) { //go over column
                    if (vis[r][c]) continue; // skip if already visited
                    int v = A[r][c]; // value at cell
                     // If current cell value not in {k, k+1}, it cannot start/join a component for this pass
                    if (v != k && v != k + 1) continue; // not part of this pair

                    int size = 0; // size of current connected component
                    ArrayDeque<int[]> q = new ArrayDeque<>(); // queue for BFS
                     // Start BFS from (r, c)
                    q.add(new int[]{r, c}); // Enqueue starting cell
                    vis[r][c] = true; // Mark starting cell as visited

                    // Perform BFS
                    while (!q.isEmpty()) {
                        int[] p = q.poll(); // Dequeue front cell
                        size++; // Increment size of current component
                        int pr = p[0], pc = p[1]; // current row, column

                        // Explore 4 possible directions
                        for (int d = 0; d < 4; d++) { // for each direction
                            int nr = pr + DIR[d], nc = pc + DIR[d + 1]; // new row, new column
                             // Check bounds
                            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue; // out of bounds
                             // Skip if already visited
                            if (vis[nr][nc]) continue; // already visited

                            int nv = A[nr][nc]; //neiqhbor value
                             // If neighbor value is in {k, k+1}, add to component
                            if (nv == k || nv == k + 1) {
                                vis[nr][nc] = true;
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
                    best = Math.max(best, size); // Update best size if needed
                }
            }
        }
        return best; // Return size of largest connected component found
    }


     public static void main(String[] args) {
        Solution sol = new Solution();


        int[][] t1 = {
            {3, 4, 6},
            {2, 7, 6}
        };
        
        System.out.println("Example 1: " + (sol.solution(t1)));


        int[][] t2 = {
            {3, 3, 5, 6},
            {6, 7, 2, 2},
            {5, 2, 3, 8},
            {5, 9, 2, 3},
            {1, 2, 3, 4}
        };
        System.out.println("Example 2: " + (sol.solution(t2)));

        int[][] t3 = {
            {4, 4, 2, 4, 4, 4}
        };
        System.out.println("Example 3: " + (sol.solution(t3)));

        int[][] t4 = {
            {0},
            {3},
            {5}
        };
        System.out.println("Example 4: " + (sol.solution(t4)));
    }


}
