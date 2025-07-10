
// PROBLEM 7:
// Given two linked lists sorted in increasing order.
// Merge them such a way that the result list is in decreasing order (reverse order).

// Examples:

// Input:  a: 5->10->15->40
//        b: 2->3->20
// Output: res: 40->20->15->10->5->3->2

// Input:  a: NULL
//        b: 2->3->20
// Output: res: 20->3->2


package Problems;

public class Seven {
    
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
}
    }

    // Print the merged lists
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

    Node sortedMerge(Node node1, Node node2) {
       
        if (node1 == null && node2 == null) {
            return null; // If both lists are empty, return null
        }

        Node result = null;

        while (node1 != null && node2 != null) {
            // Compare the data of the two nodes, // and insert the larger one at the beginning of the result list
            if (node1.data <= node2.data) {
                Node temp = node1.next;
                node1.next = result;
                result = node1;
                node1 = temp; // Move to the next node in the first list}
        } else {
            // If the second node's data is larger, insert it at the beginning of the result list
            Node temp = node2.next;
            node2.next = result;
            result = node2;
            node2 = temp; // Move to the next node in the second list
        }  
    }

    // If one of the lists is exhausted, append the remaining nodes of the other list to the result
    while (node1 != null) {
        Node temp = node1.next;
        node1.next = result;
        result = node1;
        node1 = temp; // Move to the next node in the first list
    }
    while (node2 != null) {
        Node temp = node2.next;
        node2.next = result;
        result = node2;
        node2 = temp; // Move to the next node in the first list
    }
        return result; // Return the merged list in reverse order
    }


public static void main(String[] args) {
        Seven.LinkedList list1 = new Seven.LinkedList();
        Seven.LinkedList list2 = new Seven.LinkedList();
        Seven seven = new Seven();

        int[] arr1 = {5, 10, 15, 40};
        int[] arr2 = {2, 3, 20};
        
        for (int x : arr1) {
            list1.insert(x);
        }
        
        for (int x : arr2) {
            list2.insert(x);
        }

        System.out.println("List 1:");
        seven.printList(list1.head); 
        System.out.println("List 2:");
        seven.printList(list2.head);

        
        Node mergedList = seven.sortedMerge(list1.head, list2.head);
        
        System.out.println("Merged List in Reverse Order:");
        seven.printList(mergedList);
    }
}