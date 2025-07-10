// PROBLEM1:
// Modify linked list in such a way that last node become the first node of the list.
// eg:
// list:{1,2,3,4}
// output:{4,1,2,3}




package Problems;

import LastToFirst.LastToFirst;

public class PrblmOne {

    public class Node {
       int data; 
       Node next; 

    Node(int data) {
        this.data = data; 
        this.next = null; 
    }
}

 private Node head, tail;

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
            System.out.println("List is empty");
            return;
        }
        Node current = head; // Start from the head
        while (current != null) {
            System.out.print(current.data + " "); // Print the current node's data
            current = current.next; // Move to the next node
        }
        System.out.println(); // Print a new line at the end
    }

    public void moveLastToFirst() {
       if (head == null || head.next == null) {
        return; // If the list is empty or has only one node, do nothing
       } 
       // Update the head to the last node
       Node current = head;
       // Pointer that moves to find tail
       while (current.next != tail) {
           current = current.next; // Move to the next node
       }
       Node lastNode = tail; // Store the last node
         current.next = null; // Set the second last node's next to null
         tail = current; // Update the tail to the second last node
            lastNode.next = head; // Link the last node's next to the current head
            head = lastNode; // Update the head to the last node
    }




    public static void main(String[] args) {
       LastToFirst list = new LastToFirst();

       int[] input = {1,2,3,4};
       for (int num : input) {
           list.insertAtEnd(num);
       }

  

        System.out.println("Original List:");
        list.printList();

        System.out.println("After moving last to front:");
        list.moveLastToFirst();
        list.printList();
    }

}
