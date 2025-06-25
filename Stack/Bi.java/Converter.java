
public class Converter {
   public void decimalToBinary(int arg) {
        IntStack stack = new IntStack();
        int num = arg;

        while (num > 0) {
            int remainder = num % 2;
            stack.push(remainder);
            num = num / 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        // We'll pop and print here next
    }

    public void binaryToDecimal(String binary) {
        IntStack stack = new IntStack();
        
        for (int i = 0; i < binary.length(); i++) {
             int digit = binary.charAt(i) - '0';
             stack.push(digit);

        }
        int position = 0; // keeps track of power of two
        int result = 0; // running total

        while (!stack.isEmpty()) {
            int bit = stack.pop();
            result += bit * Math.pow(2, position);
            position++; // increment possition

            
        }

        System.out.print(result);


        }



    }




// Given a singly linked list, write a function to swap elements pairwise.

// Input : 1->2->3->4->5->6->NULL
// Output : 2->1->4->3->6->5->NULL

// Input : 1->2->3->4->5->NULL
// Output : 2->1->4->3->5->NULL

// Input : 1->NULL
// Output : 1->NULL

// iven two linked lists sorted in increasing order.
//  Merge them such a way that the result list is in decreasing order (reverse order).

// Examples:

// Input:  a: 5->10->15->40
//         b: 2->3->20
// Output: res: 40->20->15->10->5->3->2

// Input:  a: NULL
//         b: 2->3->20
// Output: res: 20->3->2
