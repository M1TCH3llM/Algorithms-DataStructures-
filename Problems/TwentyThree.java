// Spiral order traversal of a binary tree
//            1
//        2         3
//     4     5    6   7

// the result will be(1,2,3,7,6,5,4) or(1,3,2,4,5,6,7)


package Problems;

public class TwentyThree {

    public static class SpiralOrderTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Get the height of the tree
    public static int height(Node node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Print nodes at a given level in a specific direction
    static void printLevel(Node node, int level, boolean leftToRight) {
        if (node == null) return;

        if (level == 1) {
            System.out.print(node.data + " ");
        } else if (level > 1) {
            if (leftToRight) {
                printLevel(node.left, level - 1, leftToRight);
                printLevel(node.right, level - 1, leftToRight);
            } else {
                printLevel(node.right, level - 1, leftToRight);
                printLevel(node.left, level - 1, leftToRight);
            }
        }
    }

    // Spiral order traversal
    static void spiralOrder(Node root) {
        int h = height(root);
        boolean leftToRight = false;

        for (int i = 1; i <= h; i++) {
            printLevel(root, i, leftToRight);
            leftToRight = !leftToRight; // Toggle direction
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Spiral Order Traversal:");
        spiralOrder(root);
    }
}

}
