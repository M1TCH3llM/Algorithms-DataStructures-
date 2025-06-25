package Stack.Problems;

public class Main {
    // Given a singly linked list, write a function to swap elements pairwise.
    
    // Input : 1->2->3->4->5->6->NULL
    // Output : 2->1->4->3->6->5->NULL
    
    // Input : 1->2->3->4->5->NULL
    // Output : 2->1->4->3->5->NULL
    
    // Input : 1->NULL
    // Output : 1->NULL

    // swap node pairs
    public static void pairwiseSwap(Node head) {
        Node curr = head;

        // Travers List 
        while (curr != null && curr.next !=null) { //ensure Nodes are paired

            // Swap data of current and next node
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;

            curr = curr.next.next;
            }
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }
     public static void main(String[] args) {
        
        // Creating the linked list: 
      	// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        
        System.out.println("Before Sort");
        
        printList(head);

        System.out.println("");
        System.out.println("After Sort");
        
        pairwiseSwap(head);

        printList(head);
    }
}
 



    





// iven two linked lists sorted in increasing order.
//  Merge them such a way that the result list is in decreasing order (reverse order).

// Examples:

// Input:  a: 5->10->15->40
//         b: 2->3->20
// Output: res: 40->20->15->10->5->3->2

// Input:  a: NULL
//         b: 2->3->20
// Output: res: 20->3->2

// ===========================================================

// Given the head of a linked list, remove the nth node from the end of the list and return its head.
// Follow up: Could you do this in one pass?

// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:
// Input: head = [1], n = 1
// Output: []
// Example 3:
// Input: head = [1,2], n = 1
// Output: [1]