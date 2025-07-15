// WRITE A program to check if the parentheses in an arithmetic expression are correctly nested or not eg 
// {(a + b) × (c + d) + (c × d)]}  
// Output : not nested 


package Problems;

import java.util.Stack;


public class Thirteen {

    static boolean isBalanced(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            else if 
            (ch == ')' || ch == '}' || ch == ']') {
                  if (st.isEmpty()) return false; 
            
               char top = st.peek();
               // check if correct pair 
              if ((ch == ')' && top == '(' ) ||
                  (ch == '}' && top == '{' ) ||
                  (ch == ']' && top == '[' )) {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }
        return st.empty();

    }
public static void main(String[] args) {
        String s1 = "{(a + b) * (c + d) + (c * d)}";
        String s2 = "{(a + b) * (c + d) + (c * d)]}";

        System.out.println(s1 + " -> " + (isBalanced(s1) ? "nested" : "not nested"));
        System.out.println(s2 + " -> " + (isBalanced(s2) ? "nested" : "not nested"));
    }

}
