package Problems;

public class Twelve {
    int top, cap;
    int[] a;
    // Constructor to initialize the stack with a given capacity
    // The stack is initially empty, so top is set to -1
    public Twelve(int cap) {
        this.cap = cap;
        top = -1;
        a = new int[cap];
    }

    public boolean push(int x) {
        if (top >= cap -1) {
            System.out.println("Stack Overflow");
            return false;
        } 
        a[++top] = x;
        return true;
    }
    // Removes and returns the top element of the stack
    // If the stack is empty, it returns 0 and prints "Stack Underflow"
    public int pop() {
        if(top < 0) {
            System.out.println("Stacl Underflow");
            return 0;
        }
        return a[top--];
    }
    // Returns the top element of the stack without removing it
    // If the stack is empty, it returns 0 and prints "Stack is Empty"
    public int peek() {
        if (top < 0) {
            System.out.println("Stack is Empty");
            return 0;
        }
        return a[top];
        
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void printStack() {
    if (isEmpty()) {
        System.out.println("(empty)");
        return;
    }

    for (int i = top; i >= 0; i--) {
        System.out.print(a[i] + (i == 0 ? "" : " -> "));
    }
    System.out.println();
}

public static void main(String[] args) { 
        Twelve stack = new Twelve(15); 
        // s.push(10); 
        // s.push(20); 
        // s.push(30); 
        // s.push(70); 
        // s.push(40); 

        int[] arr = {52, 36, 38, 68, 24, 23, 27, 26, 59, 60, 72, 70, 80, 75,76 };
            for (int x : arr) {
               stack.push(x);
            }
    
       System.out.print("Stack before pop: ");
        stack.printStack();

        System.out.println(stack.pop() + " popped from stack");

        System.out.print("Stack after pop: ");
        stack.printStack();

        System.out.print(stack.peek());
    }
}
