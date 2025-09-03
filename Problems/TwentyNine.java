package Problems;

public class TwentyNine {
    public String solution (int U, int L, int[] C) {
        int n = C.length;
        StringBuilder upper = new StringBuilder();
        StringBuilder lower = new StringBuilder();

        for (int i = 0; i < n; i++) { // iterate over columns
             // If column sum is 2, both rows must have a 1
            if (C[i] == 2) {
                if (U > 0 && L > 0) {
                    upper.append('1'); // add 1 to upper row
                    lower.append('1'); // add 1 to lower row
                    U--;
                    L--;
                } else {
                    return "IMPOSSIBLE"; // not enough 1s left to satisfy column sum
                }
            } else if (C[i] == 1) { // If column sum is 1, one row gets a 1
                 // Prefer to put 1 in the row with more remaining 1s needed
                 // If both rows have same number of 1s needed, put in upper row
                if (U > L && U > 0) {
                    upper.append('1'); // add 1 to upper row
                    lower.append('0'); // add 0 to lower row
                    U--; 
                } else if (L >= U && L > 0) { // L >= U to prefer lower row when equal
                        // add 1 to lower row
                    upper.append('0');
                    lower.append('1');
                    L--;
                } else {
                    return "IMPOSSIBLE";
                }
            } else { // If column sum is 0, both rows get a 0
                upper.append('0');
                lower.append('0');
            }
        }

        if (U == 0 && L == 0) {
            return upper.toString() + "," + lower.toString();
        } else {
            return "IMPOSSIBLE";
        }
    }

    public static void main(String[] args) {
        TwentyNine obj = new TwentyNine();
        int U = 3;
        int L = 2;
        int[] C = {2, 1, 1, 0, 1};
            System.out.println(obj.solution(U, L, C)); 


        int U2 = 2;
        int L2 = 3;
        int[] C2 = {0, 0, 1, 1, 2};
        System.out.println(obj.solution(U2, L2, C2)); 
        
        int U3 = 2;
        int L3 = 2;
        int[] C3 = {2, 0, 2, 0};
        System.out.println(obj.solution(U3, L3, C3)); 

    }
}
