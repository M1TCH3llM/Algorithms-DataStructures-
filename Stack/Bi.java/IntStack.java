
public class IntStack {
    private final int SIZE = 100;
    private int[] stack = new int[SIZE];
    private int top = -1;

    public void push(int value) {
        if (top >= SIZE - 1) 
        throw new RuntimeException("Stack overflow");
        stack[++top] = value; 
    }

    public int pop() {
        if (isEmpty()) 
        throw new RuntimeException("Stack underflow");
        return stack[top--]; 
    }

    public boolean isEmpty() {
        return top == -1;
    }
}