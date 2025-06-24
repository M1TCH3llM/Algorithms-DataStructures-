package Stack.InfixPostfix;

public class Main {
    public static int precedence(char op){
        switch (op) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
            default: return -1;

        } 
    }

    public static String toPostfix(String infix) {
        InfixPostfix stack = new InfixPostfix();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < infix.length(); i ++) {
            char ch = infix.charAt(i);

            // Check if Expression is valad
            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            } else if (ch == '(' ){
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());

                } 
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // discart (
                } else {
                    return "Invalid Expression";
                }

            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Invalid Expression";
                        output.append(stack.pop());

        }
                return output.toString();

    }
     public static void main(String[] args) {

        // String expr = "(A+B)*C";
        String expr = "(A+B)*C-(D/E)";
        System.out.println("Infix:   " + expr);
        System.out.println("Postfix: " + toPostfix(expr)); // Should print: AB+C*
        String postfix = toPostfix(expr);
        System.out.println("Evaluating Postfix: " + postfix);

     }

// 
}
