package Stack.StackCheckVal;

public class Check {
    private Node top;

    public void push(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public char pop() {
        if (top == null) {
            throw new RuntimeException("Stack underflow - Cannot pop from an empty stack");
        }
        char popped = top.data;
        top = top.next;
        return popped;
    }

    public char peek() {
        if (top == null) {
            throw new RuntimeException("Stack is empty - Cannot peek");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

