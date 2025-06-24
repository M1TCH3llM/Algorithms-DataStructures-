

public class StackInt {
    public class NodeInt {
    int data;
    NodeInt next;

    public NodeInt(int data) {
        this.data = data;
    }
}
    private NodeInt top;

    public void push(int data) {
        NodeInt newNode = new NodeInt(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("Stack underflow");
        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek() {
        if (top == null) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
