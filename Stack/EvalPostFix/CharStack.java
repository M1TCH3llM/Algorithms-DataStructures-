package Stack.EvalPostFix;

public class CharStack {
    private final int SIZE = 100;
    private char[] stack = new char[SIZE];
    private int top = -1;

    public void push(char c) {
        if (top >= SIZE - 1) throw new RuntimeException("Stack overflow");
        stack[++top] = c;
    }

    public char pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        return stack[top--];
    }

    public char peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
