package Problems;

import java.util.ArrayList;

public class TwentyOne {

    // Main required function
    public int[] solution(int[] A) {
        // 1. Convert from base -2 to integer X
        long X = 0;
        long pow = 1; // (-2)^0
        for (int bit : A) {
            if (bit == 1) X += pow;
            pow *= -2;
        }

        // 2. Compute ceil(X / 2)
        long Y;
        if (X >= 0) {
            // For positive, ceiling = (X + 1)/2 if odd, else just X/2
            Y = (X + 1) / 2;
        } else {
            // For negative, integer division already rounds toward 0 for negative
            Y = (X / 2); // but this is actually ceil for negatives
            if (X % 2 != 0) {
                Y += 1; // adjust because Java negative division truncates
            }
        }

        // 3. Convert Y back to base -2
        if (Y == 0) return new int[]{0};

        ArrayList<Integer> result = new ArrayList<>();
        long n = Y;
        while (n != 0) {
            long remainder = n % -2;
            n /= -2;
            if (remainder < 0) {
                remainder += 2;
                n += 1;
            }
            result.add((int) remainder);
        }

        // Convert list → array
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    // Helper: print array
    private static void printBits(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    // Test with examples
    public static void main(String[] args) {
        TwentyOne sol = new TwentyOne();

    
        int[] A1 = {1,0,0,1,1}; 
        int[] result1 = sol.solution(A1);
        System.out.print("[1,0,0,1,1] => Output ");
        printBits(result1); // should print [1,0,1]

        
        int[] A2 = {1,0,0,1,1,1};
        int[] result2 = sol.solution(A2);
        System.out.print("[1,0,0,1,1,1] => Output ");
        printBits(result2); // should print [1,0,1,0,1,1]

        
        int[] A3 = {0};
        int[] result3 = sol.solution(A3);
        System.out.print("[0] => Output ");
        printBits(result3); // should print [0]
    }
}
