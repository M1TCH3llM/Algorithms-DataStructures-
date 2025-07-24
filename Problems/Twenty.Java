package Problems;

public class Twenty {
    
    public int solution(String S) {  
        int n = S.length();
        char[] arr = S.toCharArray();
        int maxLen = 0;

        // Scan possible centers
        for (int mid = 0; mid < n - 1; mid++) {
            int half = 0;
            // expand symmetrically
            while (mid - half >= 0 && mid + half + 1 < n) {
                char left = arr[mid - half];
                char right = arr[mid + half + 1];

                if ((left == '<' || left == '?') && (right == '>' || right == '?')) {
                    maxLen = Math.max(maxLen, (half + 1) * 2);
                    half++;
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Twenty sol = new Twenty();  

        String[] tests = {
            "<<??>>", 
            "??????", 
            "<<?",     
            "<<>>><", 
            "<><>",   
            "><<>>"   
        };

        for (String test : tests) {
            System.out.println("Input: " + test + 
                " Longest symmetric length = " + sol.solution(test));
        }
    }
}
