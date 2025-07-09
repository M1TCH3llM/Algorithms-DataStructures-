package Palindrome;

import java.util.Stack;

public class Palindrome {
    private Node head, tail; // Head of the linked list
     
    public void insertAtEnd(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                tail = newNode; // If the list is empty, set both head and tail to the new node
                return;
            } else {
                tail.next = newNode; // Link the current tail's next to the new node
                tail = newNode; // Update the tail to the new node
            }
        }

     public void printList() {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " , ");
        }
       
    }

    //  public Node reverse(Node node) {
    //     // three pointers to reverse the linked list
    //     Node prev = null;
    //     Node current = node;
    //     Node next = null;

    //     while (current != null) { // Traverse the list 
    //         next = current.next; // Store the next node
    //         current.next = prev; // Reverse the link
    //         prev = current; // Move prev to current
    //         current = next; // Move to the next node
    //     }
    //     return prev; // Update head to the new first node
    // }

    // ====================================== use fast and slow pointers ======================================


//         public boolean isPalindrome() {
//             if (head == null || head.next == null) {
//                 return true; // An empty list is a palindrome
//             }

//             Node slow = head;
//             Node fast = head;

//             // Step 1: Find the middle of the linked list using slow and fast pointers
//             while (fast != null && fast.next != null) {
//                 slow = slow.next; // Move slow pointer by one step
//                 fast = fast.next.next; // Move fast pointer by two steps
//         }
//           Node secondHalf = reverse(slow);


//           Node first = head;
//           Node second = secondHalf;

//             while (second != null) {
//                 if (first.data != second.data) {
//                     reverse(secondHalf);
//                     return false; // If any data doesn't match, it's not a palindrome
//                 }
//                 first = first.next; // Move to the next node in the first half
//                 second = second.next; // Move to the next node in the second half
//             }
//             reverse(secondHalf);
    
//         // The linked list is a palindrome
//         return true;
//     }   

// }

 //   public boolean isPalindrome() {
//     // Step 1: Create a reversed copy of the list
//     Node reversedHead = null;
//     // Traverse the original list and create a new reversed list
//     for (Node current = head; current != null; current = current.next) {
//         // Create a new node with the same data and insert it at the beginning of the reversed list
//         Node newNode = new Node(current.data);
//         // Insert the new node at the beginning of the reversed list
//         newNode.next = reversedHead;
//         // Update the head of the reversed list
//         reversedHead = newNode;

//     }

//     // Step 2: Compare both lists
//     Node original = head;
//     Node reversed = reversedHead;
// // Traverse both lists and compare their data
//     while (original != null && reversed != null) {
//         if (original.data != reversed.data) {
//             return false;
//         }
//         original = original.next;
//         reversed = reversed.next;

//     }


// ====================================== Use A stack to test for palindrome ======================================


        public boolean isPalindrome() {
            // create empty stack
            Stack<Integer> stack = new Stack<>();
            // use a temporary node to traverse the linked list
            Node temp = head;

            while (temp != null) {
                stack.push(temp.data); // push each element onto the stack
                temp = temp.next; // move to the next node
            }
            temp = head; // reset temp to head

            while (temp != null) {
                if (temp.data != stack.pop()) { // compare each element with the top of the
                    return false; // if they don't match, it's not a palindrome
                }
                // pop the top element from the stack
                temp = temp.next; // move to the next node

        }
            return true; // if all elements match, it's a palindrome
        }
    }



        


//rewrite without reversial
