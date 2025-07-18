package HightBalanceTree;

public class HightBalanceTree {
    
 Node root;

    public void insert(Node node) {

        root = insertHelper(root, node);

    }
    private Node insertHelper(Node root, Node node) {

        int data = node.data;

        // If the tree is empty, the new node becomes the root
        if (root == null) {
            root = node;
            return root;
        }
        // If the data is less than the root's data, insert in the left subtree
        else if( data < root.data) {
            root.left = insertHelper(root.left, node);
        }
        else {
            // If the data is greater than or equal to the root's data, insert in the right subtree
            root.right = insertHelper(root.right, node);
        }
        
         return root;
    }


     public void display() {

        displayHelper(root);
     }
     // In-order traversal of the tree
        // Left, Root, Right
     private void displayHelper(Node root) {
        if(root != null) {
            displayHelper(root.left);
            System.out.print(root.data + " ");
            displayHelper(root.right);
        } 
     }
     // Search for a node with the given data
        // Returns true if found, false otherwise
     public boolean search(int data) {
         return searchHelper(root, data);
     }

     private boolean searchHelper(Node root, int data) {
        // Base case: if the root is null, the data is not found
        // If the root is not null, check if the data matches the root's data
        if(root == null) {
            return false;
        }
        // If the data is equal to the root's data, return true
        else if (root.data == data) {
            return true;
        }
        // If the data is less than the root's data, search in the left subtree
        else if (root.data > data) {
            return searchHelper(root.left, data);
        }
        else {
            // If the data is greater than the root's data, search in the right subtree
            return searchHelper(root.right, data);
        }
     }

    public void delete(int data) {
        if (search(data)) {
        deleteHelper(root, data);
        } else {
            System.out.println("Node with value " + data + " not found in the tree.");
        }
        }

    private Node deleteHelper(Node root, int data) {
        if(root == null) {
            return root;
        }
        // Traverse the tree to find the node to be deleted
        // If the data is less than the root's data, go to the left subtree
        else if (data < root.data) {
            root.left = deleteHelper(root.left, data);
        }
        // If the data is greater than the root's data, go to the right subtree
        else if (data > root.data) {
            root.right = deleteHelper(root.right, data);
        }
        else {
            // Node with no child
            // Leaf node 
            if (root.left == null && root.right == null) {
                root = null;
            } 
            else if (root.right != null) { // find successor
                root.data = successor(root);
                root.right = deleteHelper(root.right, root.data);
            }
            else if (root.left != null) { // find predecessor
                root.data = predecessor(root);
                root.left = deleteHelper(root.left, root.data);
            }
        }
        return root;
    }
    // Find the successor of the node to be deleted
    // The successor is the minimum value in the right subtree
    private int successor(Node root) { // find the minimum value in the right child of this root node
       root = root.right;
       // Traverse to the leftmost node in the right subtree
       // The leftmost node will have the minimum value
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    // Find the predecessor of the node to be deleted
    // The predecessor is the maximum value in the left subtree
    private int predecessor(Node root) {
         root = root.left;
         // Traverse to the rightmost node in the left subtree
            // The rightmost node will have the maximum value
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
    public int getTreeHeight() {
    return height(root);
}

    private int height(Node n) {
        // if node is null return 0 else return stored hight value
        return (n == null) ? 0 : n.height;
    }

    private void updateHeight(Node n) {
    n.height = 1 + Math.max(height(n.left), height(n.right));
}

    public int getRootBalanceFactor() {
    return getBalance(root);
}

    private int getBalance(Node n) {
        // if n is null return 0, else return Balance factor
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node z = x.right;

        //rotate right
        x.right = y;
        y.left = z;

        // update hights
        updateHeight(y);
        updateHeight(x);

        System.out.println("Rotate Right");

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node z = y.left;

        //rotate left
        y.left = x;
        x.right = z;

        // update hights
        updateHeight(x);
        updateHeight(y);

        System.out.println("Rotate Left");

        return x;
    }
    


}
