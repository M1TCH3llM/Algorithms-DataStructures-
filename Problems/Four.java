// PROBLEM4:

// Given the head of a singly linked list, return true if it is a palindrome ,do it without reversing the linkedlist.
// Example 1:
// Input: head = [1,2,2,1]
// Output: true
// Example 2:
// Input: head = [1,2]
// Output: false



package Problems;

public class Four {
    public static void main(String[] args) { 
        StackImpArray s = new StackImpArray(15); 
        
        int[] arr = {1, 2, 2, 1};
        // int[] arr = {1, 2};
        for (int x : arr) {
            s.push(x);
        }

        System.out.print("Stack before pop: ");
        s.printStack();

        System.out.println("Is Palindrome? " + s.isPalindrome());
    }
}

// Implementation of a stack using an array
class StackImpArray {
    int top, cap;
    int[] a;

    public StackImpArray(int cap) {
        this.cap = cap;
        top = -1;
        a = new int[cap];
    }

    public boolean push(int x) {
        if (top >= cap - 1) {
            System.out.println("Stack Overflow");
            return false;
        } 
        a[++top] = x;
        return true;
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
    // Removes and returns the top element of the stack
    public boolean isPalindrome() {
        // Check if the stack is empty or has only one element
        if (isEmpty() || top == 0) {
            return true; // An empty stack or a single element stack is a palindrome
        }
        //
        for (int i = 0; i <= top / 2; i++) { // Check only half of the stack
            // Compare the top element with the corresponding element from the bottom
            // If they are not equal, the stack is not a palindrome
            if (a[i] != a[top - i]) {
                // a[i] is bottom or left side
                // a[top - i] is top or right side, -i // to get the corresponding element from the top
                return false;
            }
        }
        return true; 
    }
}
