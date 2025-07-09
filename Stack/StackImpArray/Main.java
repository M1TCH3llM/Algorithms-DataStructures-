package Stack.StackImpArray;

public class Main {

    public static void main(String[] args) { 
        StackImpArray s = new StackImpArray(15); 
        // s.push(10); 
        // s.push(20); 
        // s.push(30); 
        // s.push(70); 
        // s.push(40); 

        int[] arr = {52, 36, 38, 68, 24, 23, 27, 26, 59, 60, 72, 70, 80, 75,76 };
            for (int x : arr) {
               s.push(x);
            }
    
       System.out.print("Stack before pop: ");
        s.printStack();

        System.out.println(s.pop() + " popped from stack");

        System.out.print("Stack after pop: ");
        s.printStack();

        System.out.print(s.peek());
    }
}
