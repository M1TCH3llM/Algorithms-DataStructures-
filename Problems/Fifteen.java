package Problems;

public class Fifteen {
    public String palString(String S) {

        // count digits 
        int[] freq = new int[10]; // creates array
        for (char c : S.toCharArray()) { //loops over array
            // converts sting to digit 
            // and stores frequency of numbers
            freq[c - '0'] ++; // 
        }

        // build left half & track middle
        StringBuilder leftHalf = new StringBuilder(); // stores left side 
        String middleDigit = ""; // stores middle

        //Travers digits from 9 - 0 
        for (int digit = 9; digit >= 0; digit--) {
            // saves largest pair
            int pairs = freq[digit] / 2;
            // saves larges left over
            int leftover = freq[digit] % 2;

            for (int i = 0; i < pairs; i++) {
                leftHalf.append(digit);
            }

            // If there's an odd leftover, choose the largest for middle
            if(leftover == 1 && middleDigit.isEmpty()) {
                middleDigit = String.valueOf(digit);
            }
        }

        // Prepair right half
        String leftStr = leftHalf.toString();
        String rightStr = new StringBuilder(leftStr).reverse().toString();

        if (leftStr.isEmpty() && middleDigit.isEmpty()) {
            // pick largest single digit from S
            char maxDigit = '0';
            for (char c : S.toCharArray()) {
                if (c > maxDigit) maxDigit = c;
            }

            return String.valueOf(maxDigit);
        }

        // handle 0
        if (leftStr.replace("0", "").isEmpty() && middleDigit.isEmpty()) {
            return "0";
        }

        // combine
        if (!middleDigit.isEmpty()) {
            return leftStr + middleDigit + rightStr;
        } else {
            return leftStr + rightStr;
        }
    }

     public static void main(String[] args) {
        Fifteen sol = new Fifteen();

        System.out.println(sol.palString("39878"));  
        System.out.println(sol.palString("00900"));  
        System.out.println(sol.palString("0000"));  
        System.out.println(sol.palString("54321"));  
        System.out.println(sol.palString("8199"));  
     }
}
