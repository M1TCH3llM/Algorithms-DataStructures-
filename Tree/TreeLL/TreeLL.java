package Tree.TreeLL;

public class TreeLL {

    private Node head; // Head of the linked list
    private Node tail; // Tail of the linked list

    // Inner class Node
    private class Node {
        String data; // Using String to store characters like "D", "A", etc.
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    // Print the entire linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Insert a node at the end of the list
    public void insertAtEnd(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    
}
