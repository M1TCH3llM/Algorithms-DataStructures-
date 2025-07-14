
// PROBLEM 6:
// Given two sorted singly linked lists having n and m elements each,
// merge them using constant space. First n smallest elements in both the lists should become part of first list
// and rest elements should be part of second list. Sorted order should be maintained.
//  We are not allowed to change pointers of first linked list.

// For example,

// Input:
// First List: 2->4->7->8->10
// Second List: 1->3->12

// Output:
// First List: 1->2->3->4->7
// Second List: 8->10->12


package Problems;

public class Six {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
}
    }

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
        // Merges two sorted linked lists into the first list
        // The first list will contain the n smallest elements, and the second list will contain the
       public void mergeLists(Node a, Node b) {
            while (a != null && b != null) { // While both lists have nodes
                if (a.data > b.data) { //

                    int temp =a.data; // Store the data of the first list node
                    a.data = b.data; // Replace the first list node's data with the second list
                    b.data = temp; // Replace the second list node's data with the stored value

                    Node temp2 = b;

                    if (b.next != null && b.next.data < b.data) { // If the next node in the second list is smaller than the current node in the first list
                        b = b.next; // Move to the next node in the second list
                      Node ptr = b; // Pointer to traverse the second list
                      Node prev = null; // Pointer to keep track of the previous node in the second list
                   
                    while (ptr != null && ptr.data < temp2.data) { // While the current node in the second list is smaller than the current node in the first list
                                     //  System.out.println("Second while loop");

                        prev = ptr; // Update the previous pointer
                        ptr = ptr.next; // Move to the next node in the second list}
                   
                    }

                    prev.next = temp2; // Link the previous node to the current node in the second list
                    temp2.next = ptr; // Link the current node in the second list to the next
                }
        }
        a = a.next; // Move to the next node in the first list
    

    }
    
}

        // Print the merged lists
        void printList(Node node) {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println();
        }

    public static void main(String[] args) {
        Six.LinkedList list1 = new Six.LinkedList();
        Six.LinkedList list2 = new Six.LinkedList();
        
         int[] arr1 = {2, 4, 7, 8, 10};
         int[] arr2 = {1, 3, 12};
         
         for (int x : arr1) {
            list1.insert(x);
         }
         
          for (int x : arr2) {
              list2.insert(x);
          }

        list1.mergeLists(list1.head, list2.head);

        System.out.println("First List: ");
        list1.printList(list1.head);

        System.out.println("Second List: ");
        list2.printList(list2.head);
    }
}

}