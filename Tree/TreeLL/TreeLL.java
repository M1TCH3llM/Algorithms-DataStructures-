package Tree.TreeLL;

public class TreeLL {

    private Node head; // Head of the linked list
    private Node tail; // Tail of the linked list

    // Inner class Node
    private class Node {
        String data; // Using String to store characters like "D", "A", etc.
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

  class TreeNode {
    String val;
    TreeNode left, right;
    TreeNode(String val) { this.val = val; }
}

    // Print the entire linked list
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

        System.out.println("null");
    }

    public void printInorder(TreeNode root) {
    if (root == null) return;
    printInorder(root.left);
    System.out.print(root.val + " ");
    printInorder(root.right);
}
    public void printPreorder(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " ");
    printPreorder(root.left);
    printPreorder(root.right);
}


    public void insertAtEnd(String value) {
    Node newNode = new Node(value);
    if (head == null) {
        head = tail = newNode;
    } else {
        tail.next = newNode;
        tail = newNode;
    }
}

public TreeNode createTreeFromLinkedList() {
    if (head == null) return null;

    java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
    TreeNode root = new TreeNode(head.data);
    queue.add(root);

    Node currentListNode = head.next;

    while (currentListNode != null) {
        TreeNode parent = queue.poll();

        // Left child
        TreeNode left = new TreeNode(currentListNode.data);
        parent.left = left;
        queue.add(left);
        currentListNode = currentListNode.next;

        // Right child
        if (currentListNode != null) {
            TreeNode right = new TreeNode(currentListNode.data);
            parent.right = right;
            queue.add(right);
            currentListNode = currentListNode.next;
        }
    }

    return root;
}



}
