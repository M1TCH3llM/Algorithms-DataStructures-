package Stack.StackCheckVal;

public class Main {

    public static boolean isValidParentheses(String expr) {
    Check stack = new Check();

    for (int i = 0; i < expr.length(); i++) {
        char ch = expr.charAt(i);

        if (ch == '(') {
            stack.push(ch);
        } else if (ch == ')') {
            if (stack.isEmpty()) return false;
            stack.pop();
        }
    }

    return stack.isEmpty();
}
    public static void main(String[] args) {
    String expr1 = "(5*4) + 3(4-2)";      // valid
    String expr2 = "(5*4 + 3(4-2";        // invalid
    String expr3 = "(3+2)*(1+(2-1)))";    // invalid
    String expr4 = "((3+2)*(1+(2-1)))";   // valid

    System.out.println(expr1 + ": " + isValidParentheses(expr1));
    System.out.println(expr2 + ": " + isValidParentheses(expr2));
    System.out.println(expr3 + ": " + isValidParentheses(expr3));
    System.out.println(expr4 + ": " + isValidParentheses(expr4));
}
}
