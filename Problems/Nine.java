
// PROBLEM 9:

// Given a singly linked list, write a function to swap elements pairwise. For example,
// if the linked list is 1->2->3->4->5->6->7 then the function should change it to 2->1->4->3->6->5->7,
//  and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5
// Input:  1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> 8 —> NULL

// Output: 2 —> 1 —> 4 —> 3 —> 6 —> 5 —> 8 —> 7 —> NULL


package Problems;

public class Nine {
    
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
}
    }

    // Print the merged lists
      public static void printList(Node node) {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println();
        }

        // Insert from tail
 static class LinkedList {
        Node head, tail;
        
        void insert(int data) {
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
    }
    
    public static Node pairWiseSwap(Node node){ 
        if (node == null || node.next == null) {
            return node;
        }

        Node previous = node; 
        Node current = node.next;

        node = current;

        while (true) {
            Node next = current.next;
            current.next = previous;

            if (next == null || next.next == null) {
                previous.next = next;
                break;
            }

            previous.next = next.next;

            previous = next;
            current = previous.next;
        }
        return node;

    }

    public static void main(String[] args) {
        Nine.LinkedList list1 = new Nine.LinkedList();
        
         int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
         
         for (int x : arr1) {
            list1.insert(x);
         }

         System.out.println("List Before: ");
         Nine.printList(list1.head); 

         list1.head = Nine.pairWiseSwap(list1.head);
         
           System.out.println("List After Swap: ");
         Nine.printList(list1.head); 
    }
}
