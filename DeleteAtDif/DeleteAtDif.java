package DeleteAtDif;

public class DeleteAtDif {
   
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Keep only every 'difference'-th node
    public void deleteAtDifference(int difference) {
        if (head == null || difference <= 0) return;

        Node current = head;

        while (current != null) {
            Node runner = current;
            for (int i = 1; i < difference && runner.next != null; i++) {
                runner = runner.next;
            }
            // connect current to the next node to keep
            current.next = runner.next;
            current = current.next;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

