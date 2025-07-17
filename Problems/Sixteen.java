package Problems;

import java.util.*;

public class Sixteen {
    
    private static final int MAX_VALUE = (1 << 20) -1;

    public static String process(String ops) {

        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = ops.split(" ");

        for (String token : tokens) {
            if (isNumber(token)) {
                int num = Integer.parseInt(token);
                if(num < 0 || num > MAX_VALUE) return "Out of Range";
                stack.push(num);

            } else if (token.equals("POP")) {
                if(stack.isEmpty()) return "Underflow";
                stack.pop();
            }
            else if (token.equals("DUP")) {
                if(stack.isEmpty()) return "Underflow";
                stack.push(stack.peek());
            }
            else if (token.equals("-")) {
               if(stack.size() < 2) return "Underflow";
               int a = stack.pop();
               int b = stack.pop();
               int diff = a - b;
               if (diff < 0) return "ERROR5"; // underflow
               stack.push(diff);
            }
            else if (token.equals("+")) {
               if(stack.size() < 2) return "ERROR6";
               int a = stack.pop();
               int b = stack.pop();
               long sum = (long) a + b;
               if (sum > MAX_VALUE) return "ERROR7"; // underflow
               stack.push((int)sum);
            } else {
                return "ERROR8";
            }
        }

       return stack.isEmpty() ? "ERROR9" : String.valueOf(stack.peek());

    }

    private static boolean isNumber(String s) {
        // check if the token is a valid non-negative integer
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return !s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(process("4 5 6 - 7 +")); 
        System.out.println(process("3 DUP +"));   
        System.out.println(process("1048575 1 +")); 
        System.out.println(process("5 POP POP")); 
    }
}
