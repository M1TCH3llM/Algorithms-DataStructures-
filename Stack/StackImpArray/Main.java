package Stack.StackImpArray;

public class Main {

    public static void main(String[] args) { 
        StackImpArray s = new StackImpArray(5); 
        s.push(10); 
        s.push(20); 
        s.push(30); 
        s.push(70); 
        s.push(40); 
    
       System.out.print("Stack before pop: ");
        s.printStack();

        System.out.println(s.pop() + " popped from stack");

        System.out.print("Stack after pop: ");
        s.printStack();

        System.out.print(s.peek());
    }
}
