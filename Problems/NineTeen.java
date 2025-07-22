// PROBLEM 19:
//  Given a stack of integers, sort it in ascending order using another temporary stack.
// Examples: 
// Input : [34, 3, 31, 98, 92, 23]
// Output : [3, 23, 31, 34, 92, 98]


package Problems;

import java.util.Stack;

public class NineTeen {
    public static Stack<Integer> sortStack(Stack<Integer> input) {

            Stack<Integer> tempStack = new Stack<Integer>();

            while(!input.isEmpty())
            {
                // pop the first element
                int temp = input.pop();
                // while temporary stack is not empty and top of stack is lesser than temp
                while(!tempStack.isEmpty() && tempStack.peek() < temp) {
                    // Pop from OG and push into temp
                    input.push(tempStack.pop());
                }
                // push temp in to temp stack
                tempStack.push(temp);
            }
            // return temp stack
            return tempStack;
         }

         public static void main(String args[]) {

            Stack<Integer> input= new Stack<Integer>();

             int[] arr = {34, 3, 31, 98, 92, 23};

             for (int val : arr) {
            input.add(val);
        }

            Stack<Integer> tempStack = sortStack(input);
            while (!tempStack.empty())
        {
            System.out.print(tempStack.pop()+" ");
        } 
         }
}
