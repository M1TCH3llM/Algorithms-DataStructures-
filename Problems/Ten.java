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



package Problems;

public class Ten {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
}
    }

    void printList(Node node) {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println();
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
    }

    public static Node deleteNthEnd(Node head, int n) {
        Node fast = head; // fast pointer
        Node slow = head; // slow pointer

        // advance fast 1 sep more -> recurring 
        for (int i = 0; i < n; i ++) 
            fast = fast.next; 

            // if fast is null then head is the neth node from end
            if (fast == null )
                return head.next;
            
                // move both pointers till fast is at end
            while (fast.next != null ) {
                fast = fast.next;
                slow = slow.next;
            }
            // replace nth node from the end
            slow.next = slow.next.next;
            return head;
        
    }


    public static void main(String[] args) {
        Ten.LinkedList list1 = new Ten.LinkedList();
        Ten.LinkedList list2 = new Ten.LinkedList();
        Ten.LinkedList list3 = new Ten.LinkedList();
        Ten ten = new Ten();

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1};
        int[] arr3 = {1, 2};
       
        
        for (int x : arr1) {
            list1.insert(x);
        }
        
        for (int x : arr2) {
            list2.insert(x);
        }
        for (int x : arr3) {
            list3.insert(x);
        }


        // =========== List 1 ==========
        System.out.println("->List 1:");
        ten.printList(list1.head); 

         System.out.println("delete from 2nth");
        list1.head = deleteNthEnd(list1.head, 2);

         System.out.println("->List 1 After:");
        ten.printList(list1.head); 
        
        // =========== List 2 ==========

        System.out.println("->List 2:");
        ten.printList(list2.head); 

         System.out.println("delete from 1nth");
        list2.head = deleteNthEnd(list2.head, 1);

         System.out.println("->List 2 After:");
        ten.printList(list2.head); 

         // =========== List 3 ==========

        System.out.println("->List 3:");
        ten.printList(list3.head); 

         System.out.println("delete from 1nth");
        list3.head = deleteNthEnd(list3.head, 1);

         System.out.println("->List 3 After:");
        ten.printList(list3.head); 
     
}
}