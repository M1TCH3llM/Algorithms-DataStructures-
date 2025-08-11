// Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb. The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
//  Note: You can only put the bomb at an empty cell.

// Example 1:
//  Input:
// {{'0','E','0','0'},
//  {'E','0','W','E'},
//  {'0','E','0','0'}}

// Output: 3
//  (Placing a bomb at (1,1) kills 3 enemies)

//  Example:2
//  Input:
//         {{ '0', 'E', '0', '0'},
//     	   { 'E', 'E', 'W', 'E'},
//         { '0', 'E', '0', '0'}}
// Output: 2

// Explanation:
//  Placing a bomb at (0,0) or (0,3) or (2,0) or (2,3) kills 2 enemies

package Problems;

public class FiftyNine {
    public int kill(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] count = new int[rows][cols];

        // Calculate the number of enemies that can be killed horizontally
        // l => r traversal
        for (int i = 0; i < rows; ++i) {
            int rowCount = 0;
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 'W') { // Wall encountered, reset count
                    rowCount = 0;
                } else {
                    if (grid[i][j] == 'E')
                     rowCount++; // Enemy encountered, increment count
                    }
                    count[i][j] += rowCount;
                }
            }

        // Calculate the number of enemies that can be killed vertically
         for (int i = 0; i < rows; ++i) {
            int rowCount = 0;
            for (int j = cols - 1; j >= 0; --j) {
                if (grid[i][j] == 'W') {
                    rowCount = 0;
                } else {
                    if (grid[i][j] == 'E') 
                    rowCount++;
                }
                count[i][j] += rowCount;
            }
        }

        for (int j = 0; j < cols; ++j) {
            int colCount = 0;
            for (int i = 0; i < rows; ++i) {
                if (grid[i][j] == 'W') {
                    colCount = 0;
                } else {
                    if (grid[i][j] == 'E') 
                    colCount++;
                }
                    count[i][j] += colCount;
                }
        }

       for (int j = 0; j < cols; ++j) {
            int colCount = 0;
            for (int i = rows - 1; i >= 0; --i) {
                if (grid[i][j] == 'W') {
                    colCount = 0;
                } else {
                    if (grid[i][j] == 'E')
                    colCount++;
                }
                count[i][j] += colCount;
            }
        }

        // Find the best empty cell
        int maxKills = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '0') { // Empty cell, potential for a bomb
                    maxKills = Math.max(maxKills, count[i][j]);
                }
            }
        }
        return maxKills;
    }


     public static void main(String[] args) {
        FiftyNine solver = new FiftyNine();

    
        char[][] ex1 = {
            {'0','E','0','0'},
            {'E','0','W','E'},
            {'0','E','0','0'}
        };
        int out1 = solver.kill(ex1);
        System.out.println("Example1 output: " + out1);
        assert out1 == 3 : "Example 1 should be 3";

 
        char[][] ex2 = {
            {'0','E','0','0'},
            {'E','E','W','E'},
            {'0','E','0','0'}
        };
        int out2 = solver.kill(ex2);
        System.out.println("Example2 output: " + out2);
        assert out2 == 2 : "Example 2 should be 2";
    }
}

// 27 28 29 30 