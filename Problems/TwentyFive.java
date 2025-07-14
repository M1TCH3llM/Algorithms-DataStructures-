
// PROBLEM 25:

// Display the Sum of Leaf nodes of a tree .Given a binary search tree containing digits only, each root-to-leaf path could represent a number.
// Find the total sum of all leaf numbers.
// Note: A leaf is a node with no children.
// Example:
// int[] arr = {10,4,6,5,9,3,12,11,16,17};
// sum:45


package Problems;


public class TwentyFive {
    

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // BST class
    static class BST {
        Node root;

        // Insert a node
        void insert(int data) {
            root = insertRec(root, data);
        }

        Node insertRec(Node root, int data) {
            if (root == null) {
                return new Node(data);
            }
            if (data < root.data) {
                root.left = insertRec(root.left, data);
            } else {
                root.right = insertRec(root.right, data);
            }
            return root;
        }

        // Get sum of all leaf nodes
        int sumOfLeafNodes(Node node) {
            if (node == null) return 0;

            // If node is a leaf
            if (node.left == null && node.right == null) {
                return node.data;
            }

            // Otherwise sum left and right subtrees
            return sumOfLeafNodes(node.left) + sumOfLeafNodes(node.right);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 5, 9, 3, 12, 11, 16, 17};

        BST tree = new BST();
        for (int val : arr) {
            tree.insert(val);
        }

        int leafSum = tree.sumOfLeafNodes(tree.root);
        System.out.println("Sum of leaf nodes: " + leafSum); // Expected output: 45
    }
}




