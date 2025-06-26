package Stack.Problems;

public class DeleteByPosition {
  private  Node head, tail;

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


        // Print List
      public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }

     public void deleteNthFromEnd(int n) {
        Node dummy = new Node(0);
        
        Node fast = dummy;
        Node slow = dummy;

        // Move fast n+1 steps ahead

        for (int i = 0; i <=n; i++) {
            if (fast == null) return; // n is longer than the list
            fast = fast.next;
        }
        // Move both pointers until fast reaches the end

        while (fast != null) {

            fast = fast.next;
            slow = slow.next;
        
        }
        // Delete Node

        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        // Update head in case the head was removed

        head = dummy.next;

        if (head == null) {
            tail = null;
     }
    }

     public static void main(String[] args) {
        DeleteByPosition list = new DeleteByPosition();

        int[] input = {1,2,3,4,5};

        for (int num : input) list.insertAtEnd(num);

         System.out.print("Original: ");
        printList(list.head);

        list.deleteNthFromEnd(2);  // delete the 2nd node from the end

        System.out.print("After deleting 2nd from end: ");
        printList(list.head);

    }
}



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