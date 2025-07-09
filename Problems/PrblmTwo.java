package Problems;

public class PrblmTwo {

    // Definition of the ListNode class
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Static class with the solution logic
    static class AddTwoNumbers {
        // Method to add two numbers represented by linked lists
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // Create a dummy node to simplify the addition process
            ListNode dummy = new ListNode(0);
            // Pointer to the current node in the result list
            ListNode current = dummy;
            // Variable to keep track of carry from the addition
            int carry = 0;

                // Loop until both lists are processed and no carry remains
            while (l1 != null || l2 != null || carry > 0) {
                // Get the values from the current nodes of l1 and l2, or 0 if the node is null
                int val1 = (l1 != null) ? l1.val : 0;
                // Get the value from the current node of l2, or 0 if the node is null
                int val2 = (l2 != null) ? l2.val : 0;

                // Calculate the sum of the two values and the carry
                int sum = val1 + val2 + carry;
                // Update the carry for the next iteration
                carry = sum / 10;
                // Create a new node with the digit value (sum modulo 10) and attach it to the result list
                current.next = new ListNode(sum % 10);
                // Move the current pointer to the next node in the result list
                current = current.next;

                // Move to the next nodes in l1 and l2, if they exist
                if (l1 != null) l1 = l1.next;
                // Move to the next node in l2, if it exists
                if (l2 != null) l2 = l2.next;
            }
            // Return the next node of the dummy node, which is the head of the result list
            return dummy.next;
        }
    }

    // Static method to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        // // Linked list 1: 2 -> 4 -> 3 (represents 342)
        // ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        // // Linked list 2: 5 -> 6 -> 4 (represents 465)
        // ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Expected output: 7 -> 0 -> 8
        printList(result);
    }
}
