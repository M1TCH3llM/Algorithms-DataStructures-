package Stack.EvalPostFix;

public class Main {

    // Define operator precedence
    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }

    // Convert infix expression to postfix (handles multi-digit numbers)
    public static String toPostfix(String infix) {
        CharStack stack = new CharStack();  // Custom character stack
        StringBuilder output = new StringBuilder();

        // Loop through the expression character by character
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);  // Current character

            // If digit, collect entire multi-digit number
            if (Character.isDigit(ch)) {
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    output.append(infix.charAt(i));
                    i++;
                }
                output.append(' ');  // Add space to separate tokens
                i--;  // Adjust index because for-loop will increment it again
            }

            // Handle opening parenthesis
            else if (ch == '(') {
                stack.push(ch);
            }

            // Handle closing parenthesis
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();  // Discard matching '('
                } else {
                    return "Invalid Expression";  // No matching '('
                }
            }

            // Handle operators
            else if ("+-*/^".indexOf(ch) != -1) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(ch);
            }
        }

        // Pop any remaining operators
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Invalid Expression";
            output.append(stack.pop()).append(' ');
        }

        return output.toString().trim();  // Remove trailing space
    }

    // Evaluate a postfix expression (handles multi-digit numbers)
    public static int evaluatePostfix(String postfix) {
        IntStack stack = new  IntStack();  // Custom integer stack

        String[] tokens = postfix.split(" ");  // Tokenize using space

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));  // Push numbers
            } else if (token.length() == 1) {
                char op = token.charAt(0);
                int val2 = stack.pop();
                int val1 = stack.pop();

                switch (op) {
                    case '+': stack.push(val1 + val2); break;
                    case '-': stack.push(val1 - val2); break;
                    case '*': stack.push(val1 * val2); break;
                    case '/': stack.push(val1 / val2); break;
                    case '^': stack.push((int)Math.pow(val1, val2)); break;
                    default: throw new RuntimeException("Invalid operator: " + op);
                }
            } else {
                throw new RuntimeException("Invalid token: " + token);
            }
        }

        return stack.pop();  // Final result
    }

    public static void main(String[] args) {
        String expr = "(7+10)*4-(8/2)";
        System.out.println("Infix:   " + expr);
        String postfix = toPostfix(expr);
        System.out.println("Postfix: " + postfix);
        System.out.println("Result:  " + evaluatePostfix(postfix));
    }
}