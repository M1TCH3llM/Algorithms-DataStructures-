package LastToFirst;

public class LastToFirst {
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
       } // Update the head to the last node
       Node current = head;
       while (current.next != tail) {
           current = current.next; // Move to the next node
       }
       Node lastNode = tail; // Store the last node
         current.next = null; // Set the second last node's next to null
         tail = current; // Update the tail to the second last node
            lastNode.next = head; // Link the last node's next to the current head
            head = lastNode; // Update the head to the last node
    }
}
