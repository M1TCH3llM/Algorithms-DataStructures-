package Problems;


public class PrnblmThr {
    // Definition of the Node class
    static class Node {
        int data;
        Node next;
        // Constructor to initialize the node with data
        // and set the next pointer to null

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // Head of the linked list
    private Node head;

    // Constructor to initialize the linked list
    public PrnblmThr() {
        this.head = null;
    }
    // Method to insert a new node in sorted order without duplicates
    public void insertInOrder(int data) {
        // If the list is empty or the new data is less than the head's data
        if (head == null || data < head.data) {
            // Create a new node with the given data
            Node newNode = new Node(data);
            // insert the new node at the beginning
            newNode.next = head;
            // Update the head to point to the new node
            head = newNode;
            // If the data already exists in the list, do not insert it
            return;
        }
        // If the new data is equal to the head's data, do not insert it
        if (head.data == data) return; // No duplicates

        // Traverse the list to find the correct position for the new node
        Node previous = head;
        // Start with the second node
        Node current = head.next;

        // Traverse the list until we find the position where the new data should be inserted
        // or until we reach the end of the list
        while (current != null && current.data < data) {
            // Move to the next node
            previous = current;
            // Move to the next node
            current = current.next;
        }
        // If the data already exists in the list, do not insert it
        if (current != null && current.data == data) return; // No duplicates

        Node newNode = new Node(data);
        previous.next = newNode;
        newNode.next = current;
    }

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
        System.out.println();
    }


    public void mergeLists(PrnblmThr otherList) {
        if (otherList.head == null) return;

        Node current = otherList.head;
        while (current != null) {
            this.insertInOrder(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
     PrnblmThr list1 = new PrnblmThr();
     PrnblmThr list2 = new PrnblmThr();

        int[] arr1 = {3, 1, 5};
        int[] arr2 = {6, 2, 4};

        for (int val : arr1) {
            list1.insertInOrder(val);
        }

        for (int val : arr2) {
            list2.insertInOrder(val);
        }

        System.out.print("List1: ");
        list1.printList();

        System.out.print("List2: ");
        list2.printList();

        list1.mergeLists(list2);

        System.out.print("Merged & Sorted (No duplicates): ");
        list1.printList();
    }
}
