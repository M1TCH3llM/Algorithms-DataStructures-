package Palindrome;

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

     public void reverse() {
        // three pointers to reverse the linked list
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) { // Traverse the list 
            next = current.next; // Store the next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current
            current = next; // Move to the next node
        }
        head = prev; // Update head to the new first node
    }

    public boolean isPalindrome() {
    // Step 1: Create a reversed copy of the list
    Node reversedHead = null;
    // Traverse the original list and create a new reversed list
    for (Node current = head; current != null; current = current.next) {
        // Create a new node with the same data and insert it at the beginning of the reversed list
        Node newNode = new Node(current.data);
        // Insert the new node at the beginning of the reversed list
        newNode.next = reversedHead;
        // Update the head of the reversed list
        reversedHead = newNode;
    }

    // Step 2: Compare both lists
    Node original = head;
    Node reversed = reversedHead;
// Traverse both lists and compare their data
    while (original != null && reversed != null) {
        if (original.data != reversed.data) {
            return false;
        }
        original = original.next;
        reversed = reversed.next;
    }

    return true;
}


        
}


