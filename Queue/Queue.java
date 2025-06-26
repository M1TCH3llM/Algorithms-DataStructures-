package Queue;

public class Queue {
    private Node head;
    private Node tail;

    
    //// Print Helper
    public void printList() {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " -> ");
        }
        System.out.println("null");
    }


    ///// Insert @ End
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

    ///////// Delete @ Begining
    public void deleteAtFirst(int pos) {
        if (head == null) return;
        head = head.next;
        if (head == null) {
            tail = null; 
        }
        }
    }

