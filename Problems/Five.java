package Problems;


public class Five {
    
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverseEven(Node head) {
        Node dummy = new Node(0); // Dummy node to simplify the reversal process
        dummy.next = head;
        Node prev = dummy; // Previous node to keep track of the last node in the reversed
        Node current = head; // Current node to traverse the list

        while (current != null) {
            if (current.data % 2 == 0) { // Check if the current node's data is even
                Node blockStart = current; // Start of the block to reverse

                while (current != null && current.data % 2 == 0) {
                    current = current.next;
                 } // Move to the next node in the block
                    Node blockEndNext = current; // Save the next node after the block

                    Node revHead = reverseSegment(blockStart, blockEndNext);
                    prev.next = revHead; // Connect the previous node to the reversed block
                    blockStart.next = blockEndNext; // Connect the end of the reversed block to the
                    prev = blockStart; // Move the previous pointer to the end of the reversed block

                } else {
                    prev = current; // If the current node is not even, just move the previous pointer'
                    current = current.next; // Move to the next node
                }
            }
            return dummy.next; // Return the new head of the list
         
        }
    

    // helper function to reverse a segment of the linked list
    private static Node reverseSegment(Node start, Node end) {
        Node prev = null;
        Node current = start;

        while (current != end) {
            Node nextNode = current.next; // Save the next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current
            current = nextNode; // Move to the next node
        }
        return prev; // Return the new head of the reversed segment
    }

    
    public static Node buildList(int[] arr) {
        Node dummy = new Node(0), tail = dummy;
        for (int x : arr) {
            tail.next = new Node(x);
            tail      = tail.next;
        }
        return dummy.next;
    }

    public static void printList(Node head) {
        for (Node cur = head; cur != null; cur = cur.next)
            System.out.print(cur.data + (cur.next == null ? "" : ", "));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 3, 4, 6, 8, 5};
        Node head = buildList(input);

        System.out.print("Original: ");
        printList(head);

        head = reverseEven(head);

        System.out.print("Result:   ");
        printList(head);
    }
}
