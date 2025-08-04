package Problems;

public class FiftySix {

    // i & j cells n = rows m = columns
    private boolean isSafe(int i, int j, int n, int m) {
        return 0 <= i && i < n && 0 <= j && j < m;
    }

    public int oranges(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean changed; // check for changes

        int time = 0; // time counter

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // directions


        while (true) {
            changed = false;
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < m; j ++) {
                if (mat[i][j] == time + 2) {
                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        
                        // check rotten oranges neighbors
                        if(isSafe(x, y, n, m) && mat[x][y] == 1) {
                            // adds 1 if fresh orange 
                            mat[x][y] = mat[i][j] + 1;
                            // flag as changed 
                            changed = true;
                        }

                    }
                }
            }

        }
        if (!changed) {
            break;
            // if no changes where made we end the loop
        }
        time ++;
     }
     // if any fresh oranges remain return minus one
     for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            if (mat[i][j] == 1) {
                return -1;
            }
        }
    }
    return time;

    }


    public static void main(String[] args) {

        int[][] mat = {{2, 1, 0, 2, 1},
                       {1, 0, 1, 2, 1}, 
                       {1, 0, 0, 2, 1}};

        FiftySix sol = new FiftySix();

        System.out.println(sol.oranges(mat));
    }
}

// do problems 55 -57