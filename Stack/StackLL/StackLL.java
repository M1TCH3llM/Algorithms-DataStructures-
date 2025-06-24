package Stack.StackLL ;

public class StackLL{

      private Node top; // top of the linked list
      
    public StackLL() {
        this.top =null;
    }

     public void push(int data) {
            Node newNode = new Node(data); // Create a new node with the given data
            newNode.next = top; // Point the new node's next to the current top
            top = newNode; // Update the top to the new node
        }

      public int pop() {
        if (top == null) {
            throw new RuntimeException("Stack underflow - Cannot pop from an empty stack");
        }
        int popped = top.data;
        top = top.next;
        return popped;
        }
    
    public int peek() {
        if (top == null) {
            throw new RuntimeException("Stack is empty  - Cannot pop from an empty stack");
        }
        return top.data;
    }
    
    public void printStack() {
        Node current = top;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}