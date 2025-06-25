package Stack.Problems;

public class DoubleSort {
    private Node head, tail;

    // Build Linked List
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


    public static Node mergeInReverse(Node a, Node b) {
        // SLL Node
        Node result = null;
    

    while (a != null && b != null) {
        if (a.data < b.data) { // take node a
            Node temp = a.next; // save next of a
            a.next = result; // push to front of result
            result = a; // update result head
            a = temp; // advance a

    } else { // take node b
        Node temp = b.next; // save next of b
        b.next = result; // push b to front of result
        result = b; // update result head
        b = temp; // advance
    }
    }
    // Process the rest of the nodes

    while (a != null) {
        Node temp = a.next;
        a.next = result;
        result = a; 
        a = temp;
    }

     while (b != null) {
        Node temp = b.next;
        b.next = result;
        result = b; 
        b = temp;
    }

    return result;

}

 
     public static void main(String[] args) {
         DoubleSort listA = new DoubleSort();
        DoubleSort listB = new DoubleSort();

        // int[] input1 = {5, 10, 15, 40};
        // int[] input2 = {2, 3, 20};
        
        int[] input1 = {};
        int[] input2 = {2, 3, 20};

        for (int num : input1) listA.insertAtEnd(num);
        for (int num : input2) listB.insertAtEnd(num);

        Node result = mergeInReverse(listA.head, listB.head);
        System.out.print("Merged in decreasing order: ");
        printList(result);
    }
       
    }



// Given two linked lists sorted in increasing order.
//  Merge them such a way that the result list is in decreasing order (reverse order).

// Examples:

// Input:  a: 5->10->15->40
//         b: 2->3->20
// Output: res: 40->20->15->10->5->3->2

// Input:  a: NULL
//         b: 2->3->20
// Output: res: 20->3->2
