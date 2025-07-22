package Problems;

import java.util.Stack;

public class NineTeen {
    public static Stack<Integer> sortStack(Stack<Integer> input) {

            Stack<Integer> tempStack = new Stack<Integer>();

            while(!input.isEmpty())
            {
                int temp = input.pop();

                while(!tempStack.isEmpty() && tempStack.peek() < temp) {

                    input.push(tempStack.pop());
                }
                tempStack.push(temp);
            }
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
