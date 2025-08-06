package Problems;

public class FiftySeven {

    static boolean isSafe(int[][] grid, int r, int c, boolean[][] visited) { 
        // get grid size
        int row = grid.length;
        int col = grid[0].length;

        return (r >= 0) && (r < row) && (c >= 0) && (c < col) && (grid[r][c] == 1 && !visited[r][c]); // checks if is inside grid / is land and / not visited yet => return true if all are true else false
                }

    static void dfs(int[][] grid, int r, int c, boolean[][] visited) {
        // neighbours of a given cell
        // 8 directions surrounding cell
        int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[r][c] = true; // mark current as visited

        for (int k = 0; k < 8; ++k) {
            int newR = r + rNbr[k];
            int newC = c + cNbr[k];
            // if neighbor is land cell visit it recursively
            if (isSafe(grid, newR, newC, visited)) {
                dfs(grid, newR, newC, visited);
            }
        }
    }

    static int countIslands(int[][] grid) {
        // gid size 
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col]; // creates "visited" matrix

        int count = 0; // initializes island count
        // loops through matrix
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                // if cell 1 and has not been visited then u found new land
                if (grid[r][c] == 1 && !visited[r][c]) {
                    dfs(grid, r, c, visited);

                    ++ count;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] island = {
            {1,1,1,1,0},
            {1,1,0,1,0},
            {1,1,0,0,0},
            {0,0,0,0,0},
        };
        int[][] island1 = {
            {1,1,1,1,0},
            {1,1,0,0,0},
            {1,1,0,0,1},
            {0,1,1,1,1},
        };
        int[][] island2 = {
            {1,1,1,1,0},
            {1,1,0,1,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
        };

        System.out.println("Island 1: " + countIslands(island));
        System.out.println("Island 2: " + countIslands(island1));
        System.out.println("Island 3: " + countIslands(island2));
    }
}

// 58 - 59