package Stack.StackImpArray;

public class StackImpArray {
    int top, cap;
    int[] a;

    public StackImpArray(int cap) {
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

    public int pop() {
        if(top < 0) {
            System.out.println("Stacl Underflow");
            return 0;
        }
        return a[top--];
    }

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
}