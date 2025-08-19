package Problems;

import java.util.*;

class TwentySeven {
        static final long MOD = 1_000_000_000L;

        public int solution(int[] A, int C1, int C2) {
            int N = A.length;
            if (N==0) return 0; //empty Array

            long sum = 0;
            int minA = Integer.MAX_VALUE;
            int maxA = Integer.MIN_VALUE;

            // Iterate through Array
                for (int x : A) {
                    sum += x;
                    minA = Math.min(minA, x);
                    maxA = Math.max(maxA, x);
                }

                // raise to max with singles if its not cheeper to do with pairs
                if (C2 >= 2L * C1 || N == 1 ) {
                    long K = (long) N * maxA - sum;
                    long costAbs = K * (long) C1;          
                    return (int) (costAbs % MOD); 

                }

                // collect candidate targets
                HashSet<Long> targets = new HashSet<>();
                targets.add((long) maxA);
                if ((N & 1) == 1) targets.add((long) maxA + 1); // parity flip can help when pairs are cheap

             if (N >= 3) {
                long num = sum - 2L * minA;
                long den = N - 2L;
                long tStar = (num + den - 1) / den; // ceil(num/den), careful with negatives (but here num >= 0 and den > 0)
                if (tStar < maxA) tStar = maxA;
                targets.add(tStar);
                targets.add(tStar + 1);
                if (tStar > maxA) targets.add(tStar - 1);
            }

            Long bestAbs = null;
        for (long T : targets) {
            if (T < maxA) continue; // ensure T>=maxA
            long K = (long) N * T - sum;          // total units needed
            long m = T - minA;                    // largest single deficit
            long Rraw = 2L * m - K;
            long R = Math.max(0L, Rraw);          // forced singles by dominance
            long s = R + (((K - R) & 1L) == 1L ? 1L : 0L); // add 1 if parity requires
            long pairs = (K - s) / 2L;

           long costAbs = pairs * (long) C2 + s * (long) C1;
            if (bestAbs == null || costAbs < bestAbs) bestAbs = costAbs;
        }
        return (int) (bestAbs % MOD);

        }

        public static void main(String[] args) {
            TwentySeven sol = new TwentySeven();

    // Example 1
    int[] A1 = {1, 4};
    int ans1 = sol.solution(A1, 15, 3);
    System.out.println("Example 1 → " + ans1); // Expected 45

    // Example 2
    int[] A2 = {2, 11, 11, 11, 12};
    int ans2 = sol.solution(A2, 10, 4);
    System.out.println("Example 2 → " + ans2); // Expected 54

    // Example 3
    int[] A3 = {1000000, 2, 1, 2, 1000000};
    int ans3 = sol.solution(A3, 10000, 4000);
    System.out.println("Example 3 → " + ans3); // Expected 999998000

    // Example 4
    int[] A4 = {500000, 0, 500000, 500000, 500000};
    int ans4 = sol.solution(A4, 10000, 3000);
    System.out.println("Example 4 → " + ans4); // Expected 10000

        }

}