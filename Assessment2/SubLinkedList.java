package Assessment2;

public class SubLinkedList {
    
    
   static class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

    public static long countAtMost(Node head, int K) {
        long count = 0;
        long length = 0;
        Node current = head;

        while (current != null) {
            if (current.data <= K) {
                length++; // extend current valid block
            } else {
                // block ends, add its contribution
                count += length * (length + 1) / 2;
                length = 0; // reset
            }
            current = current.next;
        }
        // last block contribution
        count += length * (length + 1) / 2;

        return count;
    }

    // Count sublists where max [L, R]
    public static long countSubLists(Node head, int L, int R) {
        // calculates 
        return countAtMost(head, R) - countAtMost(head, L - 1);
    }

    // Helper: build linked list from array
    public static Node linkedList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 4, 3};
        int L = 2, R = 3;

        Node head = linkedList(arr);

        long result = countSubLists(head, L, R);
        System.out.println(result); 
    }
}