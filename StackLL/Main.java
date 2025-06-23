package StackLL ;

public class Main {
    // implement a stack with five elements using a linked list
    // Push And Pull
    public static void main(String[] arg) {
        StackLL stack = new StackLL();

        stack.push(30);
        stack.push(15);
        stack.push(42);
        stack.push(68);
        stack.push(11);

        stack.printStack();

        System.out.println("Top: " + stack.peek());
        System.out.println("Popped: " + stack.pop());

        stack.printStack();

        stack.push(22);

        stack.printStack();

    }
    // Insert at begining & Delete From Begining


}

//Home work Jun 23rd
// Using Stack
// Implement Stack Using Array 
// Check the nesting of parethaneses (valid expression)
// Convert infix to post fix
// evaluating postfix expressions
// convert decimal to binary & vice versa

